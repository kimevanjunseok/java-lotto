package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinNumber {
    public static List<Integer> winNumbers;

    public WinNumber(String winNumber) {
        List<Integer> winNumbers = makeWinNumbers(makeNumbers(winNumber));
        isOverSix(winNumbers);
        this.winNumbers = winNumbers;
    }

    private List<String> makeNumbers(String winNumber) {
        return Arrays.asList(winNumber.split(","));
    }

    private void isOverSix(List<Integer> inputs) {
        if (inputs.size() > 6) {
            throw new IllegalArgumentException("숫자가 6개를 초과할 수 없습니다.");
        }
    }

    private List<Integer> makeWinNumbers(List<String> inputs) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            numbers.add(isNumberFormat(input));
        }
        return numbers;
    }

    private int isNumberFormat(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자가 아니야");
        }
    }
}