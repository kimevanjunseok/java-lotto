package lotto.domain;

public class LottoCount {

    private int count;

    private LottoCount(int count) {
        validateNegative(count);
        this.count = count;
    }

    public static LottoCount from(int count) {
        return new LottoCount(count);
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

    public boolean isNotZero() {
        return count != 0;
    }
}