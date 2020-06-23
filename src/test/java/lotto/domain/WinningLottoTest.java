package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    void validate_BonusBall() {
        String input = "1, 2, 3, 4, 5, 6";
        int bonusBall = 2;
        assertThatThrownBy(() -> WinningLotto.from(input, bonusBall))
                .isInstanceOf(IllegalArgumentException.class);
    }
}