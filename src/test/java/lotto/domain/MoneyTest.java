package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(longs = {-100, -1})
    void validate_Negative(long input) {
        assertThatThrownBy(() -> Money.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(longs = {1, 12, 123, 1234})
    void validate_Unit(long input) {
        assertThatThrownBy(() -> Money.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculateAutoCount() {
        Money money = Money.from(10_000L);
        assertThat(money.calculateAutoCount(3)).isEqualTo(7);
    }

    @Test
    void calculateAutoCount_Error() {
        Money money = Money.from(1_000L);
        assertThatThrownBy(() -> money.calculateAutoCount(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculateYield() {
        Money money = Money.from(10_000L);
        assertThat(money.calculateYield(120_000L)).isEqualTo(1_200L);
    }
}
