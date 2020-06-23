package lotto.domain;

import java.util.Map;

public class Result {

    private Map<RankType, Integer> countRankType;

    private Result(Map<RankType, Integer> countRankType) {
        this.countRankType = countRankType;
    }

    public static Result from(Map<RankType, Integer> countRankType) {
        return new Result(countRankType);
    }
}
