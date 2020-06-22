package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final List<LottoNumber> ticket;

    private LottoTicket(List<LottoNumber> ticket) {
        this.ticket = new ArrayList<>(ticket);
    }

    public static LottoTicket from(List<LottoNumber> ticket) {
        validateSize(ticket);
        return new LottoTicket(ticket);
    }

    private static void validateSize(List<LottoNumber> ticket) {
        if (ticket.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
