package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Movement;
import racingcar.domain.dto.CarDto;

public class CarsTest {

    private final Movement movableMovement = () -> true;
    private final Movement notMovableMovement = () -> false;
    private List<String> carNames;
    private Cars cars;

    @BeforeEach
    void setUp() {
        carNames = List.of("hwan", "pobi", "leo");
        cars = Cars.ofNames(carNames);
    }

    @Test
    void 자동차들은_전진할_수_있다() {
        cars.move(movableMovement);

        List<CarDto> carDtos = cars.getCarsInfo();
        carDtos.forEach(carDto -> assertThat(carDto.getPosition()).isGreaterThan(0));
    }

    @Test
    void 자동차들은_정지할_수_있다() {
        cars.move(notMovableMovement);

        List<CarDto> carDtos = cars.getCarsInfo();
        carDtos.forEach(carDto -> assertThat(carDto.getPosition()).isEqualTo(0));
    }

    @Test
    void 자동차_이름은_중복될_수_없다() {
        List<Car> duplicatedCars = List.of(new Car("hwan"), new Car("hwan"));

        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(duplicatedCars));
    }
}
