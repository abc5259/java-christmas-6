package christmas.domain.discount.event;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.discount.condition.AmountDiscountCondition;
import christmas.domain.discount.condition.DateDiscountCondition;
import christmas.domain.discount.policy.IncrementAmountDiscountPolicy;
import java.time.LocalDate;
import java.util.List;

public class ChristmasDiscount implements Discount {
    private static final IncrementAmountDiscountPolicy INCREMENT_AMOUNT_DISCOUNT_POLICY = new IncrementAmountDiscountPolicy(
            LocalDate.of(2023, 12, 1),
            1000,
            100,
            List.of(
                    new DateDiscountCondition(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25)),
                    new AmountDiscountCondition(10000)
            )
    );

    @Override
    public int calculateDiscountAmount(Date date, Order order) {
        return INCREMENT_AMOUNT_DISCOUNT_POLICY.calculateDiscountAmount(date, order);
    }
}
