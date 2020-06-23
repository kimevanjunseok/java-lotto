package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoTicketFactoryTest {

    @Test
    void create() {
        AutoLottoTicketFactory autoLottoTicketFactory = AutoLottoTicketFactory.from(3);
        List<LottoTicket> lottoTickets = autoLottoTicketFactory.create();
        assertThat(lottoTickets).hasSize(3);
    }
}