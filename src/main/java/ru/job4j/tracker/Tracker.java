package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Tracker {

    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];


    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
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
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }


    /**
     * Метод реализует поиск заявок по имени.
     *
     * @return массив элементов совпавших по имени.
     */
    public Item[] findByName(String key) {
        Item[] findByName = new Item[position];
        int size = 0;
        for (int index = 0; index < position; index++) {
            Item item = this.items[index];
            if (item.getName().equals(key)) {
                findByName[size++] = this.items[index];
            }
        }
        return Arrays.copyOf(findByName, size);
    }

    /**
     * Метод реализует поиск заявок по уникальному ключу.
     *
     * @return элемент по ключу.
     */
    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    /**
     * Метод реализует поиск индекса по ключу.
     *
     * @return индекс.
     */
    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
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
        item.setId(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index] = item;
        }
        return rsl;
    }


    /**
     * Метод производит удаление элемента по ключу.
     */
    public boolean delete(String id) {
        boolean result = false;
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index] = null;
            System.arraycopy(items, index + 1, items, index, position - index);
            items[position - 1] = null;
            position--;
            result = true;
        }
        return result;
    }
}