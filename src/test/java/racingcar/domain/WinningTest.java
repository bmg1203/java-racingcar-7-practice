package racingcar.domain;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class WinningTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test
    void 우승자_계산_테스트() {
        //given
        List<String> splitCarName = List.of("a", "b", "c");
        RacingCars racingCars = new RacingCars();
        Map<String, Integer> cars = racingCars.initializeCars(splitCarName);

        Winning winning = new Winning();
        Set<String> expectedWinningCars = Set.of("a", "c");

        //when % then
        assertRandomNumberInRangeTest(
                () -> {
                    racingCars.attemptMoveCarsInOneRound();
                    winning.findMaxPosition(cars);

                    Set<String> actualWinningCars = winning.findWinningCars(cars);
                    assertThat(actualWinningCars).isEqualTo(expectedWinningCars);
                }
                , MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
}