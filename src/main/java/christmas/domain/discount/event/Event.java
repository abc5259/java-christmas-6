package christmas.domain.discount.event;

public enum Event {
    CHRISTMAS("크리스마스 디데이 할인", new ChristmasDiscount()),
    WEEKDAY("평일 할인", new WeekDaysDiscount()),
    WEEKEND("주말 할인", new WeekendDiscount()),
    SPECIAL("특별 할인", new SpecialDiscount()),
    GIVEAWAY("증정 이벤트", new GiveawayDiscount());

    private final String name;
    private final Discount discount;

    Event(String name, Discount discount) {
        this.name = name;
        this.discount = discount;
    }

    public Discount getDiscount() {
        return discount;
    }

    public String getName() {
        return name;
    }
}
