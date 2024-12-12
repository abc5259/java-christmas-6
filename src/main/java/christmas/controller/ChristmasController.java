package christmas.controller;

import christmas.domain.Date;
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
        
    }
}
