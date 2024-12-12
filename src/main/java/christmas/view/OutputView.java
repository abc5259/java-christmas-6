package christmas.view;

public class OutputView {

    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }
}
