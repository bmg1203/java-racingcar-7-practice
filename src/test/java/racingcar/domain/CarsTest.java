package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private final Car CAR_POBI = new Car("pobi", 3);
    private final Car CAR_NANA = new Car("nana", 1);
    private final Car CAR_JUN = new Car("jun", 3);

    @Test
    void Cars_객체_생성() {
        List<Car> carList = List.of(new Car("pobi"), new Car("nana"));
        Cars cars = new Cars(carList);
        assertThat(cars).isEqualTo(new Cars(carList));
    }

    @Test
    void 우승자_한_명_찾기() {
        List<Car> carList = List.of(CAR_POBI, CAR_NANA);
        Cars cars = new Cars(carList);

        List<String> winners = List.of("pobi");
        assertThat(cars.findWinners()).isEqualTo(winners);
    }

    @Test
    void 우승자_여러_명_찾기() {
        List<Car> carList = List.of(CAR_POBI, CAR_NANA, CAR_JUN);
        Cars cars = new Cars(carList);

        List<String> winners = List.of("pobi", "jun");
        assertThat(cars.findWinners()).isEqualTo(winners);
    }
}
