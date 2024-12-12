package christmas.domain;

public record Date(
        int date
) {

    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    public Date {
        if (date < MIN_DATE || date > MAX_DATE) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}

