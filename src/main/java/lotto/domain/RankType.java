package lotto.domain;

import java.util.Arrays;

public enum RankType {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    NONE(0, 0, false);

    private final int prize;
    private final int match;
    private final boolean bonus;

    RankType(int prize, int match, boolean bonus) {
        this.prize = prize;
        this.match = match;
        this.bonus = bonus;
    }

    public static RankType findType(LottoTicket lottoTicket, WinningLotto winningLotto) {
        return Arrays.stream(RankType.values())
                .filter(type -> type.isRank(lottoTicket, winningLotto))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isRank(LottoTicket lottoTicket, WinningLotto winningLotto) {
        int match = winningLotto.getMatchCount(lottoTicket);
        boolean bonus = winningLotto.hasBonusByLottoTicket(lottoTicket);
        return this.match == match && this.bonus == bonus;
    }
}
