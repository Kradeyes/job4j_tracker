package ru.job4j.tracker;

import java.util.*;

public class Tracker {

    /**
     * Массив для хранения заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание.
     * Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод выводит все заявки.
     *
     * @return массив всех не null элементов.
     */
    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    /**
     * Метод реализует поиск заявок по имени.
     *
     * @return массив элементов совпавших по имени.
     */
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item x : items) {
            if (x.getName().equals(key)) {
                rsl.add(x);
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод реализует поиск заявок по уникальному ключу.
     *
     * @return элемент по ключу.
     */
    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     * Метод реализует поиск индекса по ключу.
     *
     * @return индекс.
     */
    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }

        return rsl;
    }

    /**
     * Метод производит замену элемента по ключу.
     */
    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            this.items.set(index, item);
        }
        return rsl;
    }

    /**
     * Метод производит удаление элемента по ключу.
     */
    public boolean delete(String id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            this.items.remove(index);
        }
        return rsl;
    }
}