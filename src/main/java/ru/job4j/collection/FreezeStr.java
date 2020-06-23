package ru.job4j.collection;

import java.util.Arrays;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] firstWord = left.toCharArray();
        char[] secondWord = right.toCharArray();
        Arrays.sort(firstWord);
        Arrays.sort(secondWord);
        if (firstWord.length == secondWord.length) {
            return Arrays.equals(firstWord, secondWord);
        }
        return false;
    }
}