package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CountTest {

    @Test
    void validate_Negative() {
        assertThatThrownBy(() -> Count.from(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
