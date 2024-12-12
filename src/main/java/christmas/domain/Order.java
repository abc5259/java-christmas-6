package christmas.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Order {
    private final List<OrderItem> orderItems;

    public Order(List<OrderItem> orderItems) {
        int total = orderItems.stream().mapToInt(OrderItem::count).sum();
        if (total > 20) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        if (orderItems.size() > new HashSet<>(orderItems).size()) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        this.orderItems = orderItems;
    }

    public int getTotalAmount() {
        return orderItems.stream()
                .mapToInt(OrderItem::getTotalAmount)
                .sum();
    }

    public boolean contains(Category category) {
        return orderItems.stream()
                .anyMatch(orderItem -> orderItem.isEqualCategory(category));
    }

    public int getCategoryMenuCount(Category category) {
        return orderItems.stream()
                .filter(orderItem -> orderItem.isEqualCategory(category))
                .mapToInt(OrderItem::count)
                .sum();
    }

    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }
}
