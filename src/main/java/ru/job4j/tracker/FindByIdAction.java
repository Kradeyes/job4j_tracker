package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "==== Find by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item item = tracker.findById(input.askStr("Enter Id: "));
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("No application found");
        }
        return true;
    }
}

