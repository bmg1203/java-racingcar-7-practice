package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {

    @Test
    void 자동차_경주의_우승자는_최소_한_명_이다() {
        RacingGame racingGame = new RacingGame(3);
        List<Car> racingCars = List.of(new Car("pobi"), new Car("woni"));
        racingGame.apply(racingCars);
        racingGame.start();

        List<Car> winners = racingGame.getWinners();
        assertTrue(winners.size() > 0);
    }

    private static Stream<Arguments> generateRacingCars() {
        return Stream.of(
                Arguments.of(Collections.emptyList()),
                Arguments.of(List.of(new Car("pobi")))
        );
    }

    @ParameterizedTest
    @MethodSource("generateRacingCars")
    void 경주에_참여할_자동차는_최소_2대_이상_있어야_한다(List<Car> racingCars) {
        RacingGame racingGame = new RacingGame(3);

        assertThrows(IllegalArgumentException.class, () -> racingGame.apply(racingCars));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 경주에_참여하려면_최소_1라운드_이상_설정해야_한다(int round) {
        assertThrows(IllegalArgumentException.class, () -> new RacingGame(round));
    }

}