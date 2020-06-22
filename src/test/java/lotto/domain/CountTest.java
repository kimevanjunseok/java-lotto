package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CountTest {

    @Test
    void validate_Negative() {
        assertThatThrownBy(() -> Count.from(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculateAutoCount() {
        Money money = Money.from(10_000);
        Count count = Count.from(3);
        assertThat(count.calculateAutoCount(money)).isEqualTo(7);
    }
}
