package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoTicket {

    private final List<LottoNumber> ticket;

    private LottoTicket(List<LottoNumber> ticket) {
        validateSize(ticket);
        this.ticket = new ArrayList<>(ticket);
    }

    private static void validateSize(List<LottoNumber> ticket) {
        if (ticket.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static LottoTicket from(List<LottoNumber> ticket) {
        return new LottoTicket(ticket);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return ticket.contains(lottoNumber);
    }

    public int matchCount(LottoTicket lottoTicket) {
        return (int) ticket.stream()
                .filter(lottoTicket::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(ticket, that.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }

    @Override
    public String toString() {
        return String.valueOf(ticket);
    }
}
