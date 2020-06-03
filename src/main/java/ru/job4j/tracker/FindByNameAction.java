package ru.job4j.tracker;
import java.util.List;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "==== Find by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> item = tracker.findByName(input.askStr("Enter name: "));
        if (item.size() != 0) {
            for (int i = 0; i < item.size(); i++) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("No application found");
        }
        return true;
    }
}