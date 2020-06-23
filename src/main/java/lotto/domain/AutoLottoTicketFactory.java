package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoTicketFactory implements LottoTicketFactory {

    private final int count;

    private AutoLottoTicketFactory(int count) {
        this.count = count;
    }

    public static AutoLottoTicketFactory from(int count) {
        return new AutoLottoTicketFactory(count);
    }

    @Override
    public List<LottoTicket> create() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int count = 0; count < this.count; count++) {
            lottoTickets.add(LottoTicket.from(createTicket()));
        }
        System.out.println(lottoTickets.toString());
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
