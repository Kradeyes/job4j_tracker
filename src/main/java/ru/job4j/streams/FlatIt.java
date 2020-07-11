package ru.job4j.streams;

import java.util.*;

public class FlatIt {
    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        List<Integer> rsl = new ArrayList<>();
        while (it.hasNext()) {
            Iterator<Integer> notReady = it.next();
            while (notReady.hasNext()) {
                rsl.add(notReady.next());
            }
        }
        return rsl;
    }
}