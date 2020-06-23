package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTypeTest {

    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        );
        lottoTicket = LottoTicket.from(lottoNumbers);
    }

    @Test
    void rankType_First() {
        WinningLotto winningLotto = WinningLotto.from("1, 2, 3, 4, 5, 6", 7);

        RankType type = RankType.findType(lottoTicket, winningLotto);
        assertThat(type).isEqualTo(RankType.FIRST);
    }

    @Test
    void rankType_Second() {
        WinningLotto winningLotto = WinningLotto.from("1, 2, 3, 4, 5, 8", 6);

        RankType type = RankType.findType(lottoTicket, winningLotto);
        assertThat(type).isEqualTo(RankType.SECOND);
    }

    @Test
    void rankType_Third() {
        WinningLotto winningLotto = WinningLotto.from("1, 2, 3, 4, 5, 8", 7);

        RankType type = RankType.findType(lottoTicket, winningLotto);
        assertThat(type).isEqualTo(RankType.THIRD);
    }

    @Test
    void rankType_Fourth() {
        WinningLotto winningLotto = WinningLotto.from("1, 2, 3, 4, 8, 9", 7);

        RankType type = RankType.findType(lottoTicket, winningLotto);
        assertThat(type).isEqualTo(RankType.FOURTH);
    }

    @Test
    void rankType_Fifth() {
        WinningLotto winningLotto = WinningLotto.from("1, 2, 3, 8, 9, 10", 7);

        RankType type = RankType.findType(lottoTicket, winningLotto);
        assertThat(type).isEqualTo(RankType.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 8, 9, 10, 11", "1, 12, 8, 9, 10, 11", "13, 12, 8, 9, 10, 11"})
    void rankType_NONE(String input) {
        WinningLotto winningLotto = WinningLotto.from(input, 7);

        RankType type = RankType.findType(lottoTicket, winningLotto);
        assertThat(type).isEqualTo(RankType.NONE);
    }
}