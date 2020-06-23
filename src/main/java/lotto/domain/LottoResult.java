package lotto.domain;

import java.util.Map;

public class LottoResult {

    private Map<RankType, Integer> countRankType;

    private LottoResult(Map<RankType, Integer> countRankType) {
        this.countRankType = countRankType;
    }

    public static LottoResult from(Map<RankType, Integer> countRankType) {
        return new LottoResult(countRankType);
    }

    public int getRankCount(RankType type) {
        return countRankType.get(type);
    }

    public long calculateTotalPrize() {
        long sumPrize = 0L;
        for (RankType type : RankType.values()) {
            sumPrize += type.getPrize() * countRankType.get(type);
        }
        return sumPrize;
    }
}
