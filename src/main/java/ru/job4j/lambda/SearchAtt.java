package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> rsl = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        return filter(list, rsl);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> rsl = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return filter(list, rsl);
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predict) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att:list) {
            if (predict.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}