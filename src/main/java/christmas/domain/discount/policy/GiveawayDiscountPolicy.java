package christmas.domain.discount.policy;

import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.discount.condition.DiscountCondition;
import java.util.List;

public class GiveawayDiscountPolicy implements DiscountPolicy {

    private final Menu giveawayMenu;
    private final List<DiscountCondition> discountConditions;

    public GiveawayDiscountPolicy(Menu giveawayMenu, List<DiscountCondition> discountConditions) {
        this.giveawayMenu = giveawayMenu;
        this.discountConditions = discountConditions;
    }


    @Override
    public int calculateDiscountAmount(Date date, Order order) {
        for (DiscountCondition discountCondition : discountConditions) {
            if (!discountCondition.isSatisfiedBy(date, order)) {
                return 0;
            }
        }

        return giveawayMenu.getPrice();
    }
}
