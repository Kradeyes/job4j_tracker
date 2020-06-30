package ru.job4j.streams;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static ru.job4j.streams.School.collect;

public class SchoolTest {
   private List<Student> students = List.of(
            new Student("Petrov", 90),
            new Student("Ivanov", 60),
            new Student("Sidorov", 20),
            new Student("Ivanova", 70)
    );

    @Test
    public void aClass() {
        List<Student> expected = List.of(
                new Student("Petrov", 90),
                new Student("Ivanova", 70)
        );
        List<Student> rsl = collect(students, student -> student.getScore() >= 70);
        assertEquals(expected, rsl);
    }

    @Test
    public void bClass() {
        List<Student> expect = List.of(
                new Student("Ivanov", 60)
                );
        List<Student> rsl = collect(students, student -> student.getScore() >= 50
                                                       && student.getScore() < 70);
        assertEquals(expect, rsl);
    }

    @Test
    public void cClass() {
        List<Student> expected = List.of(
                new Student("Sidorov", 20)
        );
        List<Student> rsl = collect(students, student -> student.getScore() < 50);
        assertEquals(expected, rsl);
    }
}