package ru.job4j.collection;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        char[] firstWord = left.toLowerCase().toCharArray();
        char[] secondWord = right.toLowerCase().toCharArray();

        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                          'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        Map<Character, Integer> map = new HashMap<>();
        for (char l : letters) {
            map.put(l, 0);
        }

        for (int i = 0; i < firstWord.length; i++) {
            Integer countLeft = map.get(firstWord[i]);
            map.put(firstWord[i], ++countLeft);
            Integer countRight = map.get(secondWord[i]);
            map.put(secondWord[i], --countRight);
        }

        for (Integer mapCheck : map.values()) {
            if (mapCheck != 0) {
                return false;
            }
        }

        return true;
    }
}
