package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    void calculateTotalPrize() {
        Map<RankType, Integer> countRankType = new HashMap<>();
        countRankType.put(RankType.FIRST, 1);
        countRankType.put(RankType.SECOND, 1);
        countRankType.put(RankType.THIRD, 0);
        countRankType.put(RankType.FOURTH, 1);
        countRankType.put(RankType.FIFTH, 1);
        countRankType.put(RankType.NONE, 10);
        LottoResult lottoResult = LottoResult.from(countRankType);
        assertThat(lottoResult.calculateTotalPrize()).isEqualTo(2_030_055_000L);
    }
}