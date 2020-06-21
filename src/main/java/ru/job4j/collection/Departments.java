package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = value.split("/")[0];
            for (String el : value.split("/")) {
                String rsl = el.equals(start) ? start : start + "/" + el;
                tmp.add(rsl);
            }
        }
            return new ArrayList<>(tmp);
        }

  public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}

