package christmas.domain.discount.condition;

import christmas.domain.Category;
import christmas.domain.Date;
import christmas.domain.Order;

public class CategoryDiscountCondition implements DiscountCondition {

    private final Category category;

    public CategoryDiscountCondition(Category category) {
        this.category = category;
    }

    @Override
    public boolean isSatisfiedBy(Date date, Order order) {
        return order.contains(category);
    }
}
