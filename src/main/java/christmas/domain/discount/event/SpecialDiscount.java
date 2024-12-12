package christmas.domain.discount.event;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.discount.condition.AmountDiscountCondition;
import christmas.domain.discount.condition.DateDiscountCondition;
import christmas.domain.discount.condition.StarDiscountCondition;
import christmas.domain.discount.policy.DiscountPolicy;
import christmas.domain.discount.policy.FixDiscountPolicy;
import java.time.LocalDate;
import java.util.List;

public class SpecialDiscount implements Discount {

    private static final DiscountPolicy FIX_DISCOUNT_POLICY = new FixDiscountPolicy(
            1000,
            List.of(
                    new StarDiscountCondition(),
                    new DateDiscountCondition(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31)),
                    new AmountDiscountCondition(10000)
            )
    );

    @Override
    public int calculateDiscountAmount(Date date, Order order) {
        return FIX_DISCOUNT_POLICY.calculateDiscountAmount(date, order);
    }
}
