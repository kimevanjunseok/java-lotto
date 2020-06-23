package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoTicketFactory implements LottoTicketFactory {

    private final Count count;

    private AutoLottoTicketFactory(Count count) {
        this.count = count;
    }

    public static AutoLottoTicketFactory from(Count count) {
        return new AutoLottoTicketFactory(count);
    }

    @Override
    public List<LottoTicket> create() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int count = 0; count < this.count.getCount(); count++) {
            lottoTickets.add(LottoTicket.from(createTicket()));
        }
        return lottoTickets;
    }

    private List<LottoNumber> createTicket() {
        List<Integer> numbers = IntStream
                .range(1, 46)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(6)
                .sorted()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }
}
