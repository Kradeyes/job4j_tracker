package ru.job4j.tracker;

import java.sql.SQLOutput;


public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAll(Tracker tracker) {
        System.out.println("=== Show All ====");
        Item[] item = tracker.findAll();
        for (int i = 0; i < item.length; i++) {
            System.out.println(item[i]);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Replace Item ====");
        String id = input.askStr("Enter Id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Replace was successful");
        } else {
            System.out.println("Replace failed");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        String id = input.askStr("Enter Id: ");
        if (tracker.delete(id)) {
            System.out.println("Removal was successful");
        } else {
            System.out.println("Removal failed");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Find by Id ====");
        Item item = tracker.findById(input.askStr("Enter Id: "));
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("No application found");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find by name ====");
        Item[] item = tracker.findByName(input.askStr("Enter name: "));
        if (item.length != 0) {
            for (int i = 0; i < item.length; i++) {
                System.out.println(item[i]);
            }
        } else {
            System.out.println("No application found");
        }
    }


    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAll(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}