package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TicketTest {

    @Test
    void validate_size() {
        List<LottoNumber> ticket1 = Arrays.asList(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5)
        );

        List<LottoNumber> ticket2 = Arrays.asList(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5)
        );

        assertThatThrownBy(() -> Ticket.from(ticket1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Ticket.from(ticket2)).isInstanceOf(IllegalArgumentException.class);
    }
}
