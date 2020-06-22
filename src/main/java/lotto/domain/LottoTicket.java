package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Ticket {

    private final List<LottoNumber> ticket;

    private Ticket(List<LottoNumber> ticket) {
        this.ticket = new ArrayList<>(ticket);
    }

    public static Ticket from(List<LottoNumber> ticket) {
        validateSize(ticket);
        return new Ticket(ticket);
    }

    private static void validateSize(List<LottoNumber> ticket) {
        if (ticket.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
