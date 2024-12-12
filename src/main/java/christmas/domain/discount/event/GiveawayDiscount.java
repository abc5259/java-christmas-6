package christmas.domain.discount.event;

import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.discount.condition.AmountDiscountCondition;
import christmas.domain.discount.condition.DateDiscountCondition;
import christmas.domain.discount.policy.GiveawayDiscountPolicy;
import java.time.LocalDate;
import java.util.List;

public class GiveawayDiscount implements Discount {

    private static final GiveawayDiscountPolicy DISCOUNT_POLICY = new GiveawayDiscountPolicy(
            Menu.샴페인,
            List.of(
                    new AmountDiscountCondition(120_000),
                    new DateDiscountCondition(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31))
            )
    );

    @Override
    public int calculateDiscountAmount(Date date, Order order) {
        return DISCOUNT_POLICY.calculateDiscountAmount(date, order);
    }

    public Menu calculateGiveawayMenu(Date date, Order order) {
        if (calculateDiscountAmount(date, order) == 0) {
            return null;
        }
        
        return Menu.샴페인;
    }
}
