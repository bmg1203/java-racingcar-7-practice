package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.MovingUnit.MOVING_FORWARD;
import static racingcar.MovingUnit.STOP;
import static racingcar.OutputView.printCars;
import static racingcar.WinnerCalculator.calculateWinners;

class WinnerCalculatorTest {
    @Test
    void 단독_우승자_계산_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            String carName = "pobi,woni";
            Cars cars = new Cars(carName);
            int raceTime = 3;

            printCars(raceTime, cars);

            List<String> expectedWinners = List.of("pobi");

            assertThat(calculateWinners(cars)).isEqualTo(expectedWinners);
        }, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP);
    }

    @Test
    void 공동_우승자_계산_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            String carName = "pobi,woni";
            Cars cars = new Cars(carName);
            int raceTime = 1;

            printCars(raceTime, cars);

            List<String> expectedWinners = Arrays.asList("pobi", "woni");

            assertThat(calculateWinners(cars)).isEqualTo(expectedWinners);
        }, MOVING_FORWARD, MOVING_FORWARD);
    }
}