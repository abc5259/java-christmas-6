package christmas.domain.discount.policy;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.discount.condition.DiscountCondition;
import java.util.List;

public class FixDiscountPolicy implements DiscountPolicy {

    private final int discountAmount;
    private final List<DiscountCondition> discountConditions;

    public FixDiscountPolicy(int discountAmount, List<DiscountCondition> discountConditions) {
        this.discountAmount = discountAmount;
        this.discountConditions = discountConditions;
    }

    @Override
    public int calculateDiscountAmount(Date date, Order order) {
        for (DiscountCondition discountCondition : discountConditions) {
            if (!discountCondition.isSatisfiedBy(date, order)) {
                return 0;
            }
        }

        return discountAmount;
    }
}
