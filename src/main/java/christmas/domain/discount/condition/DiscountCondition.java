package christmas.domain.discount.condition;

import christmas.domain.Date;
import christmas.domain.Order;

public interface DiscountCondition {
    boolean isSatisfiedBy(Date date, Order order);
}
