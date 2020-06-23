package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottoTicketFactoryTest {

    @Test
    void create() {
        List<LottoNumber> ticket1 = Arrays.asList(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        );
        List<LottoNumber> ticket2 = Arrays.asList(
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6),
            LottoNumber.from(7)
        );

        LottoTicket lottoTicket1 = LottoTicket.from(ticket1);
        LottoTicket lottoTicket2 = LottoTicket.from(ticket2);

        List<LottoTicket> expected = Arrays.asList(lottoTicket1, lottoTicket2);

        List<String> tickets = Arrays.asList(
            "1, 2, 3, 4, 5, 6",
            "2, 3, 4, 5, 6, 7"
        );

        LottoTicketFactory manualTicketFactory = ManualLottoTicketFactory.from(tickets);
        List<LottoTicket> actual = manualTicketFactory.create();

        assertThat(actual).isEqualTo(expected);
    }
}