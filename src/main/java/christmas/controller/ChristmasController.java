package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.discount.event.Event;
import christmas.view.OutputView;
import java.util.HashMap;
import java.util.Map;

public class ChristmasController {


    private final IteratorInputHandler iteratorInputHandler;
    private final OutputView outputView;

    public ChristmasController(IteratorInputHandler iteratorInputHandler, OutputView outputView) {
        this.iteratorInputHandler = iteratorInputHandler;
        this.outputView = outputView;
    }

    public void process() {
        outputView.printStartMessage();
        Date date = iteratorInputHandler.inputDate();
        Order order = iteratorInputHandler.inputOrder();

        Map<Event, Integer> discountInfos = new HashMap<>();
        for (Event event : Event.values()) {
            int discountAmount = event.getDiscount().calculateDiscountAmount(date, order);
            discountInfos.put(event, discountAmount);
        }
    }
}

