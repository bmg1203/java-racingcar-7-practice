package validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RaceCountValidatorTest {
    private Validator<Integer> raceCountValidator;

    @BeforeEach
    void setUp() {
        raceCountValidator = new RaceCountValidator();
    }

    @Nested
    @DisplayName("유효하지 않은 입력 테스트")
    class InvalidInputTest {

        @ParameterizedTest
        @DisplayName("1미만의 수는 예외 처리한다.")
        @ValueSource(ints = -1)
        void carNameMinLengthTest(Integer input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> raceCountValidator.validate(input))
                    .withMessage(Message.INVALID_MIN_RACE_COUNT.getMessage());
        }

        @ParameterizedTest
        @DisplayName("100을 초과하면 예외 처리한다.")
        @ValueSource(ints = 101)
        void carNameMaxLengthTest(Integer input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> raceCountValidator.validate(input))
                    .withMessage(Message.INVALID_MAX_RACE_COUNT.getMessage());
        }
    }

    @Nested
    @DisplayName("유효한 입력 테스트")
    class ValidInputTest {
        @ParameterizedTest
        @DisplayName("유효한 입력입니다.")
        @ValueSource(ints = 5)
        void carNameLengthTest(Integer input) {
            assertThatCode(() -> raceCountValidator.validate(input))
                    .doesNotThrowAnyException();
        }
    }
}
