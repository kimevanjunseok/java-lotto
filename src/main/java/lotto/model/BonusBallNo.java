package lotto.model;

import lotto.exception.NotNumberException;
import lotto.exception.OverlapWinNumberException;

public class BonusBallNo {

    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자가 아닙니다.";
    private static final String IS_CONTAIN_WIN_NUMBER_EXCEPTION_MESSAGE = "당첨번호와 중복되는 숫자가 있습니다.";
    private int bonusBallNo;

    public BonusBallNo(String input, WinNumbers winNumbers) {
        int inputNumber = isNumber(input);
        isContainsWinNumber(inputNumber, winNumbers);
        bonusBallNo = inputNumber;
    }

    private int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotNumberException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private void isContainsWinNumber(int inputNumber, WinNumbers winNumbers) {
        if (winNumbers.isContainNumber(inputNumber)) {
            throw new OverlapWinNumberException(IS_CONTAIN_WIN_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public int getBonusBallNo() {
        return bonusBallNo;
    }
}