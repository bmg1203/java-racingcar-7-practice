package racingcar.validationTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingExceptionStatus;
import racingcar.utils.validation.CarNameValidation;

import static org.junit.jupiter.api.Assertions.*;

public class CarNameValidationTest {

    @Test
    @DisplayName("올바른 차 이름 입력")
    void 차_이름_입력_성공(){
        String name = "hello";
        assertDoesNotThrow(() -> CarNameValidation.validate(name));
    }

    @Test
    @DisplayName("자동차 이름이 5자를 넘는 경우")
    void 차_이름_5글자_넘음_실패() {
        String name = "LongName";
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    CarNameValidation.validate(name);
                });
        assertEquals(RacingExceptionStatus.INVALID_NAME_LENGTH.getMessage(), exception.getMessage());
    }
    @Test
    @DisplayName("자동차 이름이 빈 문자열인 경우")
    void 차_이름_빈_문자열_실패() {
        String name = "";
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    CarNameValidation.validate(name);
                });
        assertEquals(RacingExceptionStatus.INVALID_NAME_BLANK.getMessage(), exception.getMessage());
    }
    @Test
    @DisplayName("자동차 이름이 공백만 포함된 경우")
    void 차_이름_공백만_실패() {
        String name = " ";
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    CarNameValidation.validate(name);
                });
        assertEquals(RacingExceptionStatus.INVALID_NAME_BLANK.getMessage(), exception.getMessage());
    }
}