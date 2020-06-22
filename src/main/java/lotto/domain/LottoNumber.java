package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private static final Map<Integer, LottoNumber> cache = new HashMap<>();

    static {
        for (int number = MINIMUM_NUMBER; number <= MAXIMUM_NUMBER; number++) {
            cache.put(number, new LottoNumber(number));
        }
    }

    private final int number;
    
    private LottoNumber(int number) {
        this.number = number;
    }
    
    public static LottoNumber from(int number) {
        validateNumberRange(number);
        return cache.get(number);
    }

    private static void validateNumberRange(int number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
