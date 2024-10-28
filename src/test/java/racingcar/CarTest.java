package racingcar;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.MovingUnit.MOVING_FORWARD;
import static racingcar.MovingUnit.STOP;

class CarTest {
    @Test
    void 자동차_4미만_전진불가_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            Car car = new Car(new CarName("pobi"));
            int expectedPosition = 0;
            car.move();

            assertThat(car.isPosition(expectedPosition)).isTrue();
        }, STOP);
    }

    @Test
    void 자동차_4이상_전진_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            Car car = new Car(new CarName("pobi"));
            int expectedPosition = 1;
            car.move();

            assertThat(car.isPosition(expectedPosition)).isTrue();
        }, MOVING_FORWARD);
    }
}