package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    private final InputView inputView = new InputView();

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 빈값이나_공백을_입력하면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> inputView.validateNotBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void 총_라운드_수가_1_미만이면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> inputView.validatePositiveRoundCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
