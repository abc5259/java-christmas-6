package christmas.domain.discount.event;

import christmas.domain.Date;
import christmas.domain.Order;

public interface Discount {
    int calculateDiscountAmount(Date date, Order order);
}
