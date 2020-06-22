package lotto.domain;

public class Count {

    private int count;

    private Count(int count) {
        validateNegative(count);
        this.count = count;
    }

    public static Count from(int count) {
        return new Count(count);
    }

    private void validateNegative(int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int calculateAutoCount(Money money) {
        return money.calculateAutoCount(count);
    }

    public int getCount() {
        return count;
    }
}
