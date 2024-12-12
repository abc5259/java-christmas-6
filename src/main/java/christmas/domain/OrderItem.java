package christmas.domain;

public record OrderItem(
        Menu menu,
        int count
) {
    public OrderItem {
        if (count < 1) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
