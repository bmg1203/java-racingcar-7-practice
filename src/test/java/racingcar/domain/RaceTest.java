package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.race.Race;
import racingcar.domain.race.RoundResult;

class RaceTest {

    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(
                new Car("Car1", () -> true),  // 항상 전진하는 전략
                new Car("Car2", () -> true),
                new Car("Car3", () -> false)  // 항상 전진하지 않는 전략
        );
    }

    @DisplayName("한 라운드가 실행되면 각 자동차가 이동한다.")
    @Test
    void runOneRound() {
        // given
        int totalRounds = 3;
        Race race = new Race(cars, totalRounds);

        // when
        race.runOneRound();

        // then
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
        assertThat(cars.get(2).getPosition()).isEqualTo(0);
    }

    @DisplayName("전체 경주가 끝나면 라운드 수와 동일한 개수의 RoundResult 목록을 반환한다.")
    @Test
    void raceStart() {
        // given
        int totalRounds = 3;
        Race race = new Race(cars, totalRounds);

        // when
        List<RoundResult> roundResults = race.raceStart();

        // then
        assertThat(roundResults).hasSize(totalRounds);

    }

    @DisplayName("모든 라운드를 실행하면, 각 라운드에서 자동차의 위치가 변화한다.")
    @Test
    void raceStart_carsMoveInRounds() {
        // given
        Race race = new Race(cars, 3);

        // when
        race.raceStart();

        // then
        assertThat(cars.get(0).getPosition()).isEqualTo(3);
        assertThat(cars.get(1).getPosition()).isEqualTo(3);
        assertThat(cars.get(2).getPosition()).isEqualTo(0);
    }

    @DisplayName("우승자를 결정한다.")
    @Test
    void decideWinners() {
        Race race = new Race(cars, 3);

        // when
        race.raceStart();
        List<Car> winners = race.decideWinners();

        // then
        // 항상 전진하는 Car1과 Car2가 공동 우승
        assertThat(winners).containsExactlyInAnyOrder(cars.get(0), cars.get(1));
    }

    @DisplayName("중복된 차 이름이 있으면 예외를 발생시킨다.")
    @Test
    void errorDuplicateCars() {
        // given
        Car car1 = new Car("Car", () -> true);
        Car car2 = new Car("Car", () -> true);
        Car car3 = new Car("Car2", () -> true);
        List<Car> carsWithDuplicateNames = Arrays.asList(car1, car2, car3);

        int totalRounds = 5;

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Race(carsWithDuplicateNames, totalRounds),
                "자동차 이름은 중복될 수 없습니다.");
    }

}