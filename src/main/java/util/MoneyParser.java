package util;

import lottoGame.money.Money;

public class MoneyParser {
    public static Money parse(String input) {
        return Money.from(NonNegativeIntegerParse.parse(input));
    }
}