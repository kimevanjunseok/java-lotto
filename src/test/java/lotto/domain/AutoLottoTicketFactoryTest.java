package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoTicketFactoryTest {

    @Test
    void create() {
        Count auto = Count.from(3);
        AutoLottoTicketFactory autoLottoTicketFactory = AutoLottoTicketFactory.from(auto);
        List<LottoTicket> lottoTickets = autoLottoTicketFactory.create();
        assertThat(lottoTickets).hasSize(3);
    }
}