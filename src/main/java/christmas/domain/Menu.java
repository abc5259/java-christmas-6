package christmas.domain;

public enum Menu {
    양송이수프("양송이수프", 6000, Category.APPETIZER),
    타파스("타파스", 5500, Category.APPETIZER),
    시저샐러드("시저샐러드", 8000, Category.APPETIZER),

    티본스테이크("티본스테이크", 55000, Category.MAIN),
    바비큐립("바비큐립", 54000, Category.MAIN),
    해산물파스타("해산물파스타", 35000, Category.MAIN),
    크리스마스파스타("크리스마스파스타", 25000, Category.MAIN),

    초코케이크("초코케이크", 15000, Category.DESERT),
    아이스크림("아이스크림", 5000, Category.DESERT),

    제로콜라("제로콜라", 3000, Category.DRINK),
    레드와인("레드와인", 60000, Category.DRINK),
    샴페인("샴페인", 25000, Category.DRINK),
    ;

    private final String name;
    private final int price;
    private final Category category;

    Menu(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
