package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void whenAscending() {
        List<Item> all = new ArrayList<>();
        all.add(new Item("Privet"));
        all.add(new Item("Poka"));
        Collections.sort(all,new ItemSortAscending());
        assertThat(all.get(0).getName(), is("Poka"));
    }



    @Test
    public void whenDescending() {
        List<Item> all = new ArrayList<>();
        all.add(new Item("Privet"));
        all.add(new Item("Poka"));
        Collections.sort(all,new ItemSortDescending());
        assertThat(all.get(0).getName(), is("Privet"));
    }
}