package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.console.InputValidator;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    void 이름이_쉼표_기준이면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> inputValidator.validateNameFormat("pobi,woni,jun"));
    }

    @Test
    void 이름이_숫자_혹은_영문자로_구성되면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> inputValidator.validateNameFormat("pobi,123,45"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "123"})
    void 이름이_하나만_있을_경우_예외가_발생하지_않는다(String name) {
        assertDoesNotThrow(() -> inputValidator.validateNameFormat(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,123:45", "pobi;123:45", "pobi,123:45)"})
    void 지정된_구분자외의_문자가_포함된_경우_예외가_발생한다(String names) {
        assertThatThrownBy(() -> inputValidator.validateNameFormat(names))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 쉼표 기준으로 구분할 수 있습니다.");
    }


    @ParameterizedTest
    @ValueSource(strings = {"123", "1", "0", "-1"})
    void 유효한_숫자_범위라면_예외가_발생하지_않는다(String number) {
        assertDoesNotThrow(() -> inputValidator.validateNumeric(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"junsu", "준수", "!!!", "34@"})
    void 숫자가_아닌_문자는_예외가_발생한다(String number) {
        assertThatThrownBy(() -> inputValidator.validateNumeric(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유효한 숫자 범위를 입력해 주세요.");
    }

}