package ru.job4j.streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public static List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                          .filter(predict)
                          .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Student> studentsForMap = List.of(
                new Student("Petrov", 90),
                new Student("Ivanov", 60),
                new Student("Sidorov", 20),
                new Student("Ivanova", 70)
        );
        Map<String, Student> map = studentsForMap.stream()
                                  .distinct()
                                  .collect(Collectors
                                          .toMap(Student::getSurname, student -> student));
    }
}
