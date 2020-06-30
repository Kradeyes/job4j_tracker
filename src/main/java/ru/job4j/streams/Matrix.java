package ru.job4j.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public static void main(String[] args) {
        Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> matrixList = Stream.of(matrix).flatMap(Arrays::stream)
                                         .collect(Collectors.toList());
    }
    }

