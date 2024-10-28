package racingcar.domain.model;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTests {
    static Stream<Arguments> invalidCarNames() {
        return Stream.of(
                Arguments.of("  ", "자동차 이름이 비어있습니다."),
                Arguments.of("", "자동차 이름이 비어있습니다."),
                Arguments.of("우아한테크코스라는매우긴이름", "자동차 이름 5자 초과 되었습니다.")
        );
    }

    @ParameterizedTest(name = "차 이름 : {0}")
    @DisplayName("잘못된 자동차 이름 입력 시 예외 발생")
    @MethodSource("invalidCarNames")
    public void invalidCarNameThrowException(String carName, String errorMessage) {
        assertThatThrownBy(() -> Car.of(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("유효한 자동차 이름 입력 시 정상 작동")
    @ValueSource(strings = {"해광", "우테코", "떡볶이최고"})
    public void validCarNameDoesNotThrowException(String carName) {
        assertThatCode(() -> Car.of(carName))
                .doesNotThrowAnyException();
    }

    private static Stream<Arguments> provideMoveConditions() {
        return Stream.of(
                Arguments.of(new MustMoveConditionEvaluator(), 1),
                Arguments.of(new MustNotMoveConditionEvaluator(), 0)
        );
    }

    @ParameterizedTest(name = "기대 이동 거리: {1}")
    @DisplayName("MoveConditionEvaluator에서 isCanMove가 true이면 전진, false이면 전진하지 않는다.")
    @MethodSource("provideMoveConditions")
    void testsMoveBasedOnCondition(MoveConditionEvaluator moveConditionEvaluator, int expectedMoveCount) {
        Car car = Car.of("우테코", moveConditionEvaluator);
        car.tryMove();
        assertThat(car.getMoveCount()).isEqualTo(expectedMoveCount);
    }

    private static class MustMoveConditionEvaluator implements MoveConditionEvaluator {
        @Override
        public boolean isCanMove() {
            return true;
        }
    }

    private static class MustNotMoveConditionEvaluator implements MoveConditionEvaluator {
        @Override
        public boolean isCanMove() {
            return false;
        }
    }
}