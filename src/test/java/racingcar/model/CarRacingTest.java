package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class CarRacingTest extends NsTest {

//    @Test
//    public void 랜덤값에_따라_전진_결정_성공() {
//        // Given
//        Car car1 = new Car("Car1");
//        Car car2 = new Car("Car2");
//        List<Car> racingCars = Arrays.asList(car1, car2);
//        CarRacing carRacing = new CarRacing(racingCars);
//
//        int initialDistanceCar1 = car1.getTotalDistance();
//        int initialDistanceCar2 = car2.getTotalDistance();
//
//        assertRandomNumberInRangeTest(
//                () -> {
//                    carRacing.moverCarsForwardRandomly();
//                }
//        );
//    }

    @Test
    void 단독우승_결정_성공() {
        // given
        Car car1 = new Car("car1", 10);
        Car car2 = new Car("car2", 20);
        Car car3 = new Car("car3", 30);
        Car car4 = new Car("car4", 40);
        List<Car> racingCars = List.of(car1, car2, car3, car4);
        CarRacing carRacing = new CarRacing(racingCars);

        // when
        List<Car> winners = carRacing.getWinners();

        // then
        assertEquals(1, winners.size()); // car4 단독 우승이어야 함
        assertThat(winners).contains(car4);
    }

    @Test
    void 공동우승_결정_성공() {
        // given
        Car car1 = new Car("car1", 10);
        Car car2 = new Car("car2", 20);
        Car car3 = new Car("car3", 30);
        Car car4 = new Car("car4", 30);
        List<Car> racingCars = List.of(car1, car2, car3, car4);
        CarRacing carRacing = new CarRacing(racingCars);

        // when
        List<Car> winners = carRacing.getWinners();

        // then
        assertEquals(2, winners.size()); // car3,car4 공동 우승이어야 함
        assertThat(winners).contains(car3);
        assertThat(winners).contains(car4);
    }

    @Test
    void 모두_정지한경우_공동우승_결정_성공() {
        // given
        Car car1 = new Car("car1", 0);
        Car car2 = new Car("car2", 0);
        Car car3 = new Car("car3", 0);
        Car car4 = new Car("car4", 0);
        List<Car> racingCars = List.of(car1, car2, car3, car4);
        CarRacing carRacing = new CarRacing(racingCars);

        // when
        List<Car> winners = carRacing.getWinners();

        // then
        assertEquals(4, winners.size()); // 모두 공동 우승이어야 함
        assertThat(winners).contains(car1);
        assertThat(winners).contains(car2);
        assertThat(winners).contains(car3);
        assertThat(winners).contains(car4);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}