package christmas.domain.discount.condition;

import christmas.domain.Date;
import christmas.domain.Order;
import java.time.LocalDate;

public class DateDiscountCondition implements DiscountCondition {

    private final LocalDate startDate;
    private final LocalDate endDate;

    public DateDiscountCondition(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean isSatisfiedBy(Date date, Order order) {
        return date.belongTo(startDate, endDate);
    }
}
