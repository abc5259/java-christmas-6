package christmas.domain.discount.event;

public enum Event {
    CHRISTMAS(new ChristmasDiscount()),
    WEEKDAY(new WeekDaysDiscount());

    private final Discount discount;

    Event(Discount discount) {
        this.discount = discount;
    }
}
