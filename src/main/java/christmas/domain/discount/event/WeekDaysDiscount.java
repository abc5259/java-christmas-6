package christmas.domain.discount.event;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import christmas.domain.Category;
import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.discount.condition.AmountDiscountCondition;
import christmas.domain.discount.condition.DateDiscountCondition;
import christmas.domain.discount.condition.DayOfWeeksDiscountCondition;
import christmas.domain.discount.policy.CategoryDiscountPolicy;
import java.time.LocalDate;
import java.util.List;

public class WeekDaysDiscount implements Discount {

    private final CategoryDiscountPolicy CATEGORY_DISCOUNT_POLICY = new CategoryDiscountPolicy(
            Category.DESERT,
            2023,
            List.of(
                    new DayOfWeeksDiscountCondition(List.of(SUNDAY, MONDAY, THURSDAY, WEDNESDAY, THURSDAY)),
                    new DateDiscountCondition(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31)),
                    new AmountDiscountCondition(10000)
            )
    );

    @Override
    public int calculateDiscountAmount(Date date, Order order) {
        return CATEGORY_DISCOUNT_POLICY.calculateDiscountAmount(date, order);
    }
}
