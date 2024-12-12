package christmas.domain.discount.policy;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.discount.condition.DiscountCondition;
import java.time.LocalDate;
import java.util.List;

public class IncrementAmountDiscountPolicy implements DiscountPolicy {

    private final LocalDate baseDate;
    private final int startAmount;
    private final int incrementAmount;
    private final List<DiscountCondition> discountConditions;

    public IncrementAmountDiscountPolicy(LocalDate baseDate, int startAmount, int incrementAmount,
                                         List<DiscountCondition> discountConditions) {
        this.baseDate = baseDate;
        this.startAmount = startAmount;
        this.incrementAmount = incrementAmount;
        this.discountConditions = discountConditions;
    }

    @Override
    public int calculateDiscountAmount(Date date, Order order) {
        for (DiscountCondition discountCondition : discountConditions) {
            if (!discountCondition.isSatisfiedBy(date, order)) {
                return 0;
            }
        }

        int day = date.difDay(baseDate);
        return startAmount + incrementAmount * day;
    }
}
