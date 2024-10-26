package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.Validator;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @DisplayName("입력된 문자열이 빈칸인 경우 IllegalArgumentException 예외 발생")
    @Test
    void validateInputNotBlank_ShouldThrowException_WhenInputIsBlank() {
        String blankInput = "   ";
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateInputNotBlank(blankInput));
    }

    @DisplayName("유효한 문자열일 경우 예외를 발생하지 않는다.")
    @Test
    void validateInputNotBlank_ShouldNotThrowException_WhenInputIsNotBlank() {
        String validInput = "Ferrari";
        assertDoesNotThrow(() -> validator.validateInputNotBlank(validInput));
    }

    @DisplayName("자동차 이름 길이가 6이 넘어가면 예외 발생")
    @Test
    void validateCarNameLength_ShouldThrowException_WhenCarNameIsTooLong() {
        String[] cars = {"Ferrari", "Porsche"};
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateCarNameLength(cars));
    }

}
