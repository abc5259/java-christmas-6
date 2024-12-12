package christmas.domain.discount.event;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;

import christmas.domain.Category;
import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.discount.condition.AmountDiscountCondition;
import christmas.domain.discount.condition.DateDiscountCondition;
import christmas.domain.discount.condition.DayOfWeeksDiscountCondition;
import christmas.domain.discount.policy.CategoryDiscountPolicy;
import java.time.LocalDate;
import java.util.List;

public class WeekendDiscount implements Discount {
    private final CategoryDiscountPolicy CATEGORY_DISCOUNT_POLICY = new CategoryDiscountPolicy(
            Category.MAIN,
            2023,
            List.of(
                    new DayOfWeeksDiscountCondition(List.of(FRIDAY, SATURDAY)),
                    new DateDiscountCondition(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31)),
                    new AmountDiscountCondition(10000)
            )
    );

    @Override
    public int calculateDiscountAmount(Date date, Order order) {
        return CATEGORY_DISCOUNT_POLICY.calculateDiscountAmount(date, order);
    }
}
