package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.enums.ErrorMessage;

public class TryCountValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    void 시도할_횟수는_비거나_공백으로_이루어진_문자열일_수_없다(String input) {
        // when & then
        assertThatThrownBy(() -> TryCountValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 시도할_횟수가_양의_정수가_아닌_숫자가_올_수_없다(int tryCount) {
        // when & then
        assertThatThrownBy(() -> TryCountValidator.validatePositiveInteger(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_TRY_COUNT.getMessage());
    }
}
