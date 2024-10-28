package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.strategy.MovableStrategy;
import racingcar.domain.strategy.RandomMovableStrategy;
import racingcar.exception.InvalidCarNameException;
import racingcar.exception.InvalidInputException;
import racingcar.validator.InputValidator;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 자동차이름과위치를정상적으로가져온다() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차가전진한다() {
        Car car = new Car("pobi");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 위치를문자열로반환한다() {
        Car car = new Car("pobi");
        car.move();
        car.move();
        assertThat(car.getPositionAsString()).isEqualTo("--");
    }

    @Test
    void 이동확률을정상적으로확인한다() {
        MovableStrategy strategy = new RandomMovableStrategy();
        int moveCount = 0;
        int trials = 10000;

        for (int i = 0; i < trials; i++) {
            if (strategy.shouldMove()) {
                moveCount++;
            }
        }

        double moveProbability = (double) moveCount / trials;
        assertThat(moveProbability).isGreaterThan(0.4).isLessThan(0.6);
    }

    @Test
    void 자동차이름의유효성을검증한다() {
        InputValidator.validateCarNames(List.of("pobi", "woni"));

        assertThatThrownBy(() -> InputValidator.validateCarNames(List.of("pobija", "woni")))
                .isInstanceOf(InvalidCarNameException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 시도할횟수의유효성을검증한다() {
        InputValidator.validateRounds(1);

        assertThatThrownBy(() -> InputValidator.validateRounds(0))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining("시도할 횟수는 1 이상이어야 합니다.");
    }
}
