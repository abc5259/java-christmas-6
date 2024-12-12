package christmas.view;

import christmas.domain.Menu;
import christmas.domain.OrderResult;
import christmas.domain.discount.event.Event;
import java.util.Map;

public class OutputView {

    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }

    public void printOrderResult(OrderResult orderResult) {
        /**
         * <할인 전 총주문 금액>
         * 142,000원
         *
         * <증정 메뉴>
         * 샴페인 1개
         *
         * <혜택 내역>
         * 크리스마스 디데이 할인: -1,200원
         * 평일 할인: -4,046원
         * 특별 할인: -1,000원
         * 증정 이벤트: -25,000원
         *
         * <총혜택 금액>
         * -31,246원
         *
         * <할인 후 예상 결제 금액>
         * 135,754원
         *
         * <12월 이벤트 배지>
         * 산타
         */

        printOrderMenus(orderResult);
        printTotalAmountBeforDiscount(orderResult);
        printGiveaway(orderResult);
        printDiscountEventInfos(orderResult);
        printBenefitAmount(orderResult);
        printPaymentAmount(orderResult);
        printBadge(orderResult);
    }

    private void printOrderMenus(OrderResult orderResult) {
        System.out.println("<주문 메뉴>");
        orderResult.getOrderItems()
                .forEach(orderItem -> System.out.printf("%s %d개%n", orderItem.menu(), orderItem.count()));
        System.out.println();
    }

    private void printBadge(OrderResult orderResult) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(orderResult.getBadge().getName());
    }

    private void printBenefitAmount(OrderResult orderResult) {
        System.out.println("<총혜택 금액>");
        System.out.printf("-%,d원%n", orderResult.getTotalBenefitAmount());
        System.out.println();
    }

    private void printPaymentAmount(OrderResult orderResult) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원%n", orderResult.getPaymentAmount());
        System.out.println();
    }

    private void printDiscountEventInfos(OrderResult orderResult) {
        System.out.println("<혜택 내역>");
        int totalBenefitAmount = orderResult.getTotalBenefitAmount();
        if (totalBenefitAmount == 0) {
            System.out.println("없음");
            System.out.println();
            return;
        }
        Map<Event, Integer> discountInfos = orderResult.getDiscountInfos();
        discountInfos.forEach((event, discount) -> {
            if (discount != 0) {
                System.out.printf("%s: -%,d원%n", event.getName(), discount);
            }
        });
        System.out.println();
    }

    private void printTotalAmountBeforDiscount(OrderResult orderResult) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원%n", orderResult.getTotalAmountBeforeDiscount());
        System.out.println();
    }

    private void printGiveaway(OrderResult orderResult) {
        System.out.println("<증정 메뉴>");
        Menu givawayMenu = orderResult.getGivawayMenu();
        if (givawayMenu == null) {
            System.out.println("없음");
            System.out.println();
            return;
        }
        System.out.println(givawayMenu.getName() + " 1개");
        System.out.println();
    }
}
