package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ShowActionTest {

    @Test
    public void whenCheckOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream(); //создали буффер для хранения
        PrintStream def = System.out;                            //получили ссылку на вывод в консоль
        System.setOut(new PrintStream(out));                     //Заменяем стандартный вывод на вывод в пямять для тестирования
        Tracker tracker = new Tracker();
        Item item = new Item("Try it");
        tracker.add(item);
        ShowAction act = new ShowAction();
        act.execute(new StubInput(new String[] {"Try it"}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(item.getName() + " " + item.getId())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);                                       // возвращаем обратно стандартный вывод в консоль.
    }
}
