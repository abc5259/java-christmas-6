package christmas.domain;

import java.util.Arrays;

public enum Star {
    DAY3(new Date(3)),
    DAY10(new Date(10)),
    DAY17(new Date(17)),
    DAY24(new Date(24)),
    DAY25(new Date(25)),
    DAY31(new Date(31));

    private final Date date;

    Star(Date date) {
        this.date = date;
    }

    public static boolean contains(Date date) {
        return Arrays.stream(Star.values())
                .anyMatch(star -> star.date.equals(date));
    }
}
