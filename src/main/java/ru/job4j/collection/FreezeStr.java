package ru.job4j.collection;

import java.util.ArrayList;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] firstWord = left.toCharArray();
        char[] secondWord = right.toCharArray();
        ArrayList<Character> first = new ArrayList<>();
        for (Character x:firstWord) {
            first.add(x);
        }
        for (Character x:secondWord) {
            first.remove(x);
        }
        return first.isEmpty();
    }
}