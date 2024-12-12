package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Date {
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    private final LocalDate date;

    public Date(int date) {
        if (date < MIN_DATE || date > MAX_DATE) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        this.date = LocalDate.of(2023, 12, date);
    }

    public boolean contains(List<DayOfWeek> dayOfWeeks) {
        return dayOfWeeks.contains(date.getDayOfWeek());
    }

    public boolean belongTo(LocalDate startDate, LocalDate endDate) {
        return (startDate.isEqual(date) || startDate.isBefore(date) &&
                (endDate.isEqual(date) || endDate.isAfter(date)));
    }

    public int difDay(LocalDate date) {
        return this.date.getDayOfMonth() - date.getDayOfMonth();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Date date1 = (Date) o;
        return date.equals(date1.date);
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }
}

