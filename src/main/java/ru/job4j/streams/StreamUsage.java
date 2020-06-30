package ru.job4j.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{" + "name='" + name + '\'' + ", spent=" + spent + '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)
        );
        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);

        List<Integer> numbers = new ArrayList<>();
        for (int i = -5; i < 6; i++) {
            numbers.add(i);
        }
        List<Integer> rsl = numbers.stream().filter(
                number -> number > 0).collect(Collectors.toList());
    }
}