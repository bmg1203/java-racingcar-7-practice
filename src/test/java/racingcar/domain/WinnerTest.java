package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinnerTest {

    private static final int STANDARD_RANDOM_NUMBER = 4;
    private Cars cars;
    private Winner winner = new Winner();

    @BeforeEach
    public void setting() {
        Map<String, Car> makeCars = new HashMap<>();
        makeCars.put("pobi", new Car("pobi"));
        makeCars.put("woni", new Car("woni"));

        cars = new Cars(makeCars);

        setDistance(cars);
    }

    private void setDistance(Cars cars) {
        cars.getCars().get("pobi").plusDistance(STANDARD_RANDOM_NUMBER);
    }

    @Test
    void 우승자_한명_테스트() {
        //when
        List<String> winners = winner.getWinners(cars);

        //then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.contains("pobi")).isTrue();
    }

    @Test
    void 우승자_여러명_테스트() {
        //given
        cars.getCars().get("woni").plusDistance(STANDARD_RANDOM_NUMBER);

        //when
        List<String> winners = winner.getWinners(cars);

        //then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.contains("pobi") &&
                winners.contains("woni")).isTrue();
    }
}