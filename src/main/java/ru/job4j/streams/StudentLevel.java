package ru.job4j.streams;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted(Student::compareTo)
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}