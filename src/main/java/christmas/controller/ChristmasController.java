package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.OrderResult;
import christmas.view.OutputView;

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

        OrderResult orderResult = new OrderResult(date, order);
        outputView.printOrderResult(orderResult);
    }
}

