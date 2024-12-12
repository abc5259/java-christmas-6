package christmas.domain.discount.condition;

import christmas.domain.Date;
import christmas.domain.Order;
import java.time.DayOfWeek;
import java.util.List;

public class DayOfWeeksDiscountCondition implements DiscountCondition {

    private final List<DayOfWeek> dayOfWeeks;

    public DayOfWeeksDiscountCondition(List<DayOfWeek> dayOfWeeks) {
        this.dayOfWeeks = dayOfWeeks;
    }

    @Override
    public boolean isSatisfiedBy(Date date, Order order) {
        return date.contains(dayOfWeeks);
    }
}
