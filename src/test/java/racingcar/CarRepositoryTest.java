package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarRepository;
import racingcar.domain.car.value.Name;

import java.util.List;

class CarRepositoryTest {



    @DisplayName("등록한 자동차들을 조회할 수 있다")
    @Test
    void addTest() {

        // given
        CarRepository carRepository = new CarRepository();
        List<Car> cars = List.of(Car.create(new Name("a")), Car.create(new Name("b")), Car.create(new Name("c")));
        List<Name> carNames = cars.stream()
                .map(Car::getName)
                .toList();

        // when
        carRepository.saveAll(cars);

        // then
        Assertions.assertThat(carRepository.findAll())
                .extracting(Car::getName)
                .containsExactlyInAnyOrderElementsOf(carNames);
    }

    @DisplayName("중복된 이름의 자동차가 등록되면 예외를 발생시킨다")
    @Test
    void addExceptionTest() {

        // given
        CarRepository carRepository = new CarRepository();
        List<Car> cars = List.of(Car.create(new Name("a")), Car.create(new Name("b")), Car.create(new Name("a")));

        // when, then
        Assertions.assertThatThrownBy(() -> carRepository.saveAll(cars))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
