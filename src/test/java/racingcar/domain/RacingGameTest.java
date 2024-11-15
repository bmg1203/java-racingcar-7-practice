package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int STANDARD_RANDOM_NUMBER = 4;
    private Cars cars;
    private RacingGame racingGame;

    @BeforeEach
    public void setting() {
        Map<String, Car> makeCars = new HashMap<>();
        makeCars.put("pobi", new Car("pobi"));
        makeCars.put("woni", new Car("woni"));

        cars = new Cars(makeCars);
        racingGame = new RacingGame(cars, 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -3, 0})
    void 시도회수_예외_테스트(int tryCount) {
        //when, then
        assertThatThrownBy(() -> new RacingGame(cars, tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤값_생성_테스트() {
        //given
        int randomNumber = racingGame.getRandomNumber();

        //when, then
        assertThat(randomNumber >= MIN_RANDOM_NUMBER &&
                randomNumber <= MAX_RANDOM_NUMBER)
                .isTrue();
    }

    @Test
    void 자동차_전진_테스트() {
        //given, when
        racingGame.execute("pobi", STANDARD_RANDOM_NUMBER);
        racingGame.execute("woni", MIN_RANDOM_NUMBER);

        //then
        assertThat(racingGame.getCars().getCars().get("pobi").getDistance())
                .isEqualTo(1);
        assertThat(racingGame.getCars().getCars().get("woni").getDistance())
                .isEqualTo(0);
    }
}