package christmas.controller;

import christmas.converter.StringToDateConverter;
import christmas.converter.StringToOrderConverter;
import christmas.domain.Date;
import christmas.domain.Order;
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

    public Order inputOrder() {
        return iteratorInputTemplate.execute(
                inputView::readMenus,
                new StringToOrderConverter()
        );
    }
}
