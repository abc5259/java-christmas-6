package christmas.domain;

import java.util.Arrays;

public enum Badge {
    SANTA(20000, "산타"),
    TREE(10000, "트리"),
    STAR(5000, "별"),
    NONE(0, "없음");

    private final int baseAmount;
    private final String name;

    Badge(int baseAmount, String name) {
        this.baseAmount = baseAmount;
        this.name = name;
    }

    public static Badge calculateBadge(int amount) {
        return Arrays.stream(Badge.values())
                .filter(badge -> badge.baseAmount <= amount)
                .sorted()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("배지를 찾을 수 없습니다."));
    }

    public String getName() {
        return name;
    }
}
