package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    void matchCountAll() {
        List<LottoNumber> lottoNumbers1 = Arrays.asList(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        );

        List<LottoNumber> lottoNumbers2 = Arrays.asList(
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6),
            LottoNumber.from(7)
        );

        List<LottoTicket> lottoTickets = Arrays.asList(
                LottoTicket.from(lottoNumbers1),
                LottoTicket.from(lottoNumbers2)
        );

        WinningLotto winningLotto = WinningLotto.from("1, 2, 3, 4, 5, 6", 7);
        LottoTickets tickets = LottoTickets.from(lottoTickets);

        Map<RankType, Integer> countRankType = tickets.matchCountAll(winningLotto);
        assertThat(countRankType.get(RankType.FIRST)).isEqualTo(1);
        assertThat(countRankType.get(RankType.SECOND)).isEqualTo(1);
    }
}