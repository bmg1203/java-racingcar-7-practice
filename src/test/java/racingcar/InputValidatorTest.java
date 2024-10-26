package racingcar;

import static org.assertj.core.api.Assertions.*;
import static racingcar.ExceptionMessage.*;
import static racingcar.InputValidator.MAX_CAR_NAME_LENGTH;
import static racingcar.InputValidator.MIN_CAR_NAME_LENGTH;
import static racingcar.InputValidator.MIN_ROUND_COUNT;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {" crong", "loopy "})
    void 자동차명_맨앞이나_맨뒤의_공백은_글자수에서_제외한다(String carName) {
        assertThatCode(() -> InputValidator.validateCarName(carName))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차명이_null이면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateCarName(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_CAR_NAME.getMessage());
    }

    @Test
    void 자동차명이_공백이면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateCarName(" "))
        .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pororo", "javajigi", "abc de"})
    void 자동차명이_5자_초과이면_예외가_발생한다(String carName) {
        assertThatThrownBy(() -> InputValidator.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(INVALID_LENGTH_RANGE_CAR_NAME.getMessage(),
                        MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH, carName));
    }

    @ParameterizedTest
    @ValueSource(strings = { "1", "10", "100"})
    void 시도_횟수가_1_이상의_정수이면_예외가_발생하지_않는다(String count) {
        assertThatCode(() -> InputValidator.validateRoundCount(count))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = { "0", "-1", "-10"})
    void 시도_횟수가_1_미만의_정수이면_예외가_발생한다(String count) {
        assertThatThrownBy(() -> InputValidator.validateRoundCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(INVALID_RANGE_ROUND_COUNT.getMessage(), MIN_ROUND_COUNT));
    }

    @ParameterizedTest
    @ValueSource(strings = { "a", "ab", "-1.5", "1.0"})
    void 시도_횟수가_정수_외_타입이면_예외가_발생한다(String count) {
        assertThatThrownBy(() -> InputValidator.validateRoundCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_TYPE_ROUND_COUNT.getMessage());
    }
}