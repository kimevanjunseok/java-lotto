package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
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
}
