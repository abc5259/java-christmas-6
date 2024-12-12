package christmas.converter;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.OrderItem;
import java.util.ArrayList;
import java.util.List;

public class StringToOrderConverter implements Converter<String, Order> {
    @Override
    public Order convert(String source) {
        // ex) 해산물파스타-2,레드와인-1,초코케이크-1
        String[] splits = source.split(",");
        List<OrderItem> orderItems = new ArrayList<>();
        for (String split : splits) {
            String[] split2 = split.split("-");
            if (split2.length != 2) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            orderItems.add(createOrderItem(split2[0], split2[1]));
        }
        return new Order(orderItems);
    }

    private OrderItem createOrderItem(String menuName, String countStr) {
        try {
            int count = Integer.parseInt(countStr);
            return new OrderItem(Menu.findByName(menuName), count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
