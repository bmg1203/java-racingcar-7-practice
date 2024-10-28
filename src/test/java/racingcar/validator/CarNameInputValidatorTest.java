package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.enums.ErrorMessage;

class CarNameInputValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    void 자동차_이름_입력은_비거나_공백으로_이루어진_문자열일_수_없다(String input) {
        // when & then
        assertThatThrownBy(() -> CarNameInputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
    }
}