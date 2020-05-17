package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "==== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Replace Item ====");
        String id = input.askStr("Enter Id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Replace was successful");
        } else {
            System.out.println("Replace failed");
        }
        return true;
    }
}
