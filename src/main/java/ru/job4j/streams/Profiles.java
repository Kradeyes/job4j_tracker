package ru.job4j.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress)
                       .sorted().distinct().collect(Collectors.toList());
    }
}
