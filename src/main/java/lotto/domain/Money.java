package lotto.domain;

public class Money {
    private static final int MONEY_UNIT = 1_000;

    private long money;

    private Money(long money) {
        validate(money);
        this.money = money;
    }

    public static Money from(long money) {
        return new Money(money);
    }

    private void validate(long money) {
        validateNegative(money);
        validateMoneyUnit(money);
    }

    private void validateNegative(long money) {
        if (money <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMoneyUnit(long money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int calculateAutoCount(int count) {
        return (int) (money / MONEY_UNIT) - count;
    }

    public long calculateYield(long totalPrize) {
        return totalPrize * 100 / money;
    }
}
