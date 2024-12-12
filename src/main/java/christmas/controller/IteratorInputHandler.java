package christmas.controller;

import christmas.converter.StringToDateConverter;
import christmas.domain.Date;
import christmas.view.InputView;

public class IteratorInputHandler {

    private final InputView inputView;
    private final IteratorInputTemplate iteratorInputTemplate;

    public IteratorInputHandler(InputView inputView, IteratorInputTemplate iteratorInputTemplate) {
        this.inputView = inputView;
        this.iteratorInputTemplate = iteratorInputTemplate;
    }

    public Date inputDate() {
        return iteratorInputTemplate.execute(
                inputView::readDate,
                new StringToDateConverter()
        );
    }

}
