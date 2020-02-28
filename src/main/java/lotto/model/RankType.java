package lotto.model;

import java.util.Arrays;

public enum RankType {
    NONE(0, 0, false),
    THREE(3, 5_000, false),
    FOUR(4, 50_000, false),
    FIVE(5, 150_000, false),
    FIVE_BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000, false);

    private final int matchCount;
    private final int prize;
    private final boolean bonusBall;

    RankType(int matchCount, int prize, boolean bonusBall) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonusBall = bonusBall;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static RankType findLottoResult(int count, boolean bonusBall) {
        return Arrays.stream(RankType.values())
            .filter(rankType -> rankType.matchCount == count && rankType.bonusBall == bonusBall)
            .findFirst()
            .orElse(NONE);
    }
}
