package christmas.domain;

import christmas.domain.discount.event.Event;
import christmas.domain.discount.event.GiveawayDiscount;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderResult {
    private final Date date;
    private final Order order;

    public OrderResult(Date date, Order order) {
        this.date = date;
        this.order = order;
    }

    public Map<Event, Integer> getDiscountInfos() {
        Map<Event, Integer> discountInfos = new HashMap<>();
        for (Event event : Event.values()) {
            int discountAmount = event.getDiscount().calculateDiscountAmount(date, order);
            discountInfos.put(event, discountAmount);
        }
        return discountInfos;
    }

    public int getTotalBenefitAmount() {
        int totalDiscountAmount = 0;
        for (Event event : Event.values()) {
            totalDiscountAmount += event.getDiscount().calculateDiscountAmount(date, order);
        }
        return totalDiscountAmount;
    }

    public int getTotalAmountBeforeDiscount() {
        return order.getTotalAmount();
    }

    public Menu getGivawayMenu() {
        GiveawayDiscount giveawayDiscount = (GiveawayDiscount) Event.GIVEAWAY.getDiscount();
        return giveawayDiscount.calculateGiveawayMenu(date, order);
    }

    public int getPaymentAmount() {
        GiveawayDiscount giveawayDiscount = (GiveawayDiscount) Event.GIVEAWAY.getDiscount();
        return order.getTotalAmount() - getTotalBenefitAmount() + giveawayDiscount.calculateDiscountAmount(date, order);
    }

    public Badge getBadge() {
        return Badge.calculateBadge(getTotalBenefitAmount());
    }

    public List<OrderItem> getOrderItems() {
        return order.getOrderItems();
    }
}
