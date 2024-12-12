package christmas.domain.discount.policy;

import christmas.domain.Date;
import christmas.domain.Order;

public interface DiscountPolicy {
    int calculateDiscountAmount(Date date, Order order);
}
