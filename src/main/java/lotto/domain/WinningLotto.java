package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private static final String COMMA = ",";

    private final LottoTicket winningLotto;
    private final LottoNumber bonusBall;

    private WinningLotto(LottoTicket winningLotto, LottoNumber bonusBall) {
        validateHasBonusBall(winningLotto, bonusBall);
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    private void validateHasBonusBall(LottoTicket winningLotto, LottoNumber bonusBall) {
        if (winningLotto.contains(bonusBall)) {
            throw new IllegalArgumentException("당첨번호가 보너스볼을 포함하고 있습니다.");
        }
    }

    public static WinningLotto from(String winningNumbers, int bonusBall) {
        List<String> lottoNumbers = Arrays.asList(winningNumbers.split(COMMA));
        List<LottoNumber> ticket = lottoNumbers.stream()
                .map(String::trim)
                .map(number -> LottoNumber.from(Integer.parseInt(number)))
                .sorted()
                .collect(Collectors.toList());

        return new WinningLotto(LottoTicket.from(ticket), LottoNumber.from(bonusBall));
    }

    public int getMatchCount(LottoTicket lottoTicket) {
        return winningLotto.matchCount(lottoTicket);
    }

    public boolean hasBonusByLottoTicket(LottoTicket lottoTicket) {
        return lottoTicket.contains(bonusBall);
    }
}