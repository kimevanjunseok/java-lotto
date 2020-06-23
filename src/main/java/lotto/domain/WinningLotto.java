package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private final LottoTicket winningLotto;
    private final LottoNumber bonusBall;

    private WinningLotto(LottoTicket winningLotto, LottoNumber bonusBall) {
        validateHasBonusBall(winningLotto, bonusBall);
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    private void validateHasBonusBall(LottoTicket winningLotto, LottoNumber bonusBall) {
        if (winningLotto.contains(bonusBall)) {
            throw new IllegalArgumentException();
        }
    }

    public static WinningLotto from(String winningNumbers, int bonusBall) {
        List<String> lottoNumbers = Arrays.asList(winningNumbers.split(","));
        List<LottoNumber> ticket = lottoNumbers.stream()
                .map(String::trim)
                .map(number -> LottoNumber.from(Integer.parseInt(number)))
                .sorted()
                .collect(Collectors.toList());

        return new WinningLotto(LottoTicket.from(ticket), LottoNumber.from(bonusBall));
    }
}
