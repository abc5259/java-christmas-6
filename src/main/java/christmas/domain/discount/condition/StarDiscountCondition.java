package christmas.domain.discount.condition;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.Star;

public class StarDiscountCondition implements DiscountCondition {
    @Override
    public boolean isSatisfiedBy(Date date, Order order) {
        return Star.contains(date);
    }
}
