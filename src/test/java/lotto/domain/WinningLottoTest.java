package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    void validate_BonusBall() {
        String input = "1, 2, 3, 4, 5, 6";
        int bonusBall = 2;
        assertThatThrownBy(() -> WinningLotto.from(input, bonusBall))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getMatchCount() {
        List<LottoNumber> ticket = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        );
        LottoTicket lottoTicket = LottoTicket.from(ticket);
        WinningLotto winningLotto = WinningLotto.from("4,5,6,7,8,9", 10);

        assertThat(winningLotto.getMatchCount(lottoTicket)).isEqualTo(3);
    }

    @Test
    void hasBonusByLottoTicket_True() {
        List<LottoNumber> ticket = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        );
        LottoTicket lottoTicket = LottoTicket.from(ticket);
        WinningLotto winningLotto = WinningLotto.from("1,2,3,4,5,7", 6);

        assertThat(winningLotto.hasBonusByLottoTicket(lottoTicket)).isTrue();
    }


    @Test
    void hasBonusByLottoTicket_False() {
        List<LottoNumber> ticket = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        );
        LottoTicket lottoTicket = LottoTicket.from(ticket);
        WinningLotto winningLotto = WinningLotto.from("1,2,3,4,5,7", 8);

        assertThat(winningLotto.hasBonusByLottoTicket(lottoTicket)).isFalse();
    }
}