package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets from(List<LottoTicket> tickets) {
        return new LottoTickets(tickets);
    }

    public static LottoTickets of(List<LottoTicket> manualTickets, List<LottoTicket> autoTickets) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.addAll(new ArrayList<>(manualTickets));
        lottoTickets.addAll(new ArrayList<>(autoTickets));
        return new LottoTickets(lottoTickets);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public Map<RankType, Integer> matchCountAll(WinningLotto winningLotto) {
        Map<RankType, Integer> countRankType = initCountRankType();
        for (LottoTicket lottoTicket : lottoTickets) {
            RankType type = RankType.findType(lottoTicket, winningLotto);
            int count = countRankType.get(type);
            countRankType.put(type, count + 1);
        }
        return countRankType;
    }

    private Map<RankType, Integer> initCountRankType() {
        Map<RankType, Integer> countRankType = new HashMap<>();
        for (RankType type : RankType.values()) {
            countRankType.put(type, 0);
        }
        return countRankType;
    }
}
