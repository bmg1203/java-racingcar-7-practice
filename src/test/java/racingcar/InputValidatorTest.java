package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest extends NsTest {
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ahn;Seong;Mo", "Ahn", "Ahn,Seong,Ahn"})
    @DisplayName("잘못된 자동차 이름 문자열 입력 예외 발생")
    void validateCarNames_InputtedWrongCarNames_ExceptionThrown(String carNames){
        //given
        final CarNameValidator carNameValidator = new CarNameValidator();
        final NumberValidator numberValidator = new NumberValidator();
        final InputValidator inputValidator = new InputValidator(carNameValidator, numberValidator);

        //when & then
        assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "BMW X5 M"})
    @DisplayName("잘못된 자동차 이름 입력 예외 발생")
    void validateCarName_InputtedWrongCarName_ExceptionThrown(String carNames){
        //given
        final CarNameValidator carNameValidator = new CarNameValidator();
        final NumberValidator numberValidator = new NumberValidator();
        final InputValidator inputValidator = new InputValidator(carNameValidator, numberValidator);

        //when & then
        assertThatThrownBy(() -> inputValidator.validateCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3, -10, -100})
    @DisplayName("잘못된 횟수 입력 예외 발생")
    void validateNumber_InputtedWrongNumber_ExceptionThrown(int number){
        //given
        final CarNameValidator carNameValidator = new CarNameValidator();
        final NumberValidator numberValidator = new NumberValidator();
        final InputValidator inputValidator = new InputValidator(carNameValidator, numberValidator);

        //when & then
        assertThatThrownBy(() -> inputValidator.validateNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
