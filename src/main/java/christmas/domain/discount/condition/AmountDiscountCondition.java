package christmas.domain.discount.condition;

import christmas.domain.Date;
import christmas.domain.Order;

public class AmountDiscountCondition implements DiscountCondition {

    private final int amount;

    public AmountDiscountCondition(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean isSatisfiedBy(Date date, Order order) {
        return order.getTotalAmount() >= amount;
    }
}
