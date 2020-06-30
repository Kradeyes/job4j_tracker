package ru.job4j.streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public static List<Student> collect(List<Student> students, Predicate<Student> predict) {
     List<Student> allStudents = new ArrayList<>(students);
        return allStudents.stream()
                          .filter(predict)
                          .collect(Collectors.toList());
    }
}
