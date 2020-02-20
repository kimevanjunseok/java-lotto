package lotto.view;

import lotto.exception.NullOrEmptyException;

import java.util.Scanner;

public class InputView {

    public static final String EMPTY_STRING = "";
    public static final String NULL_OR_EMPTY_EXCEPTION_MESSAGE = "null 혹은 빈문자열을 입력할 수 없습니다.";
    private static Scanner sc = new Scanner(System.in);

    public static String input() {
        String input = sc.nextLine();
        getWinNumbers(input);
        return input;
    }

    public static void getWinNumbers(String input) {
        if (input == null || input.equals(EMPTY_STRING)) {
            throw new NullOrEmptyException(NULL_OR_EMPTY_EXCEPTION_MESSAGE);
        }
    }
}
