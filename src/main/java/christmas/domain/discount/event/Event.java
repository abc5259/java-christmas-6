package christmas.domain.discount.event;

public enum Event {
    CHRISTMAS(new ChristmasDiscount()),
    WEEKDAY(new WeekDaysDiscount()),
    WEEKEND(new WeekendDiscount()),
    SPECIAL(new SpecialDiscount()),
    GIVEAWAY(new GiveawayDiscount());

    private final Discount discount;

    Event(Discount discount) {
        this.discount = discount;
    }
}
