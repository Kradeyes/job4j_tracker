package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Item add(Item item) {
        String insert = "insert into items(name) values (?)";
        try (PreparedStatement statement = cn.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    item.setId(resultSet.getString("id"));
                    return item;
                }
            } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new item");
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        String findAll = "select * from items";
        try(PreparedStatement statement = cn.prepareStatement(findAll)) {
            ResultSet resultSet = statement.executeQuery();
            rsl = toList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean replace(String id, Item item) {
        int i = 0;
        String replace = "update items set name = ? where id = ?";
        try (PreparedStatement statement = cn.prepareStatement(replace)) {
            statement.setString(1,item.getName());
            statement.setInt(2,Integer.parseInt(id));
            i = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i != 0;
    }

    @Override
    public boolean delete(String id) {
        int i = 0;
        String delete = "delete from items where id = ?" ;
        try (PreparedStatement statement = cn.prepareStatement(delete)) {
            statement.setInt(1,Integer.parseInt(id));
            i = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return  i != 0;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        String findById = "select * from items where id = ?";
        try(PreparedStatement statement = cn.prepareStatement(findById)) {
            statement.setInt(1,Integer.parseInt(id));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                item = new Item(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        String findByName = "select * from items where name = ?";
        try(PreparedStatement statement = cn.prepareStatement(findByName)) {
            statement.setString(1,key);
            ResultSet resultSet = statement.executeQuery();
            rsl = toList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    private List<Item> toList(ResultSet resultSet) throws SQLException {
        List<Item> items = new ArrayList<>();
        while (resultSet.next()) {
            Item item = new Item(resultSet.getString("name"));
            item.setId(resultSet.getString("id"));
            items.add(item);
        }
        return items;
    }
}
