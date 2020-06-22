package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoTicketFactory implements LottoTicketFactory {

    private List<String> tickets;

    private ManualLottoTicketFactory(List<String> tickets) {
        this.tickets = tickets;
    }

    public static ManualLottoTicketFactory from(List<String> ticket) {
        return new ManualLottoTicketFactory(ticket);
    }

    @Override
    public List<LottoTicket> create() {
        return tickets.stream()
                .map(this::ofLottoTicket)
                .collect(Collectors.toList());

    }

    private LottoTicket ofLottoTicket(String ticket) {
        List<String> splitTicket = Arrays.asList(ticket.split(","));
        List<LottoNumber> lottoTicket = splitTicket.stream()
                                            .sorted()
                                            .map(number -> LottoNumber.from(Integer.parseInt(number.trim())))
                                            .collect(Collectors.toList());
        return LottoTicket.from(lottoTicket);
    }
}
