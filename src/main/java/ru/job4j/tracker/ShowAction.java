package ru.job4j.tracker;

import java.util.List;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "==== Show All ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> item = tracker.findAll();
        for (Item x: item) {
            System.out.println(x.toString());
        }
        return true;
    }

}
