package christmas;

import christmas.controller.ChristmasController;
import christmas.controller.IteratorInputHandler;
import christmas.controller.IteratorInputTemplate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasConfig {

    private InputView inputView;
    private OutputView outputView;
    private IteratorInputTemplate iteratorInputTemplate;
    private IteratorInputHandler iteratorInputHandler;
    private ChristmasController christmasController;

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public IteratorInputTemplate iteratorInputTemplate() {
        if (iteratorInputTemplate == null) {
            iteratorInputTemplate = new IteratorInputTemplate(outputView());
        }
        return iteratorInputTemplate;
    }

    public IteratorInputHandler iteratorInputHandler() {
        if (iteratorInputHandler == null) {
            iteratorInputHandler = new IteratorInputHandler(inputView(), iteratorInputTemplate());
        }
        return iteratorInputHandler;
    }

    public ChristmasController christmasController() {
        if (christmasController == null) {
            christmasController = new ChristmasController(iteratorInputHandler(), outputView());
        }
        return christmasController;
    }
}
