package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("testCar");
    }

    @Test
    @DisplayName("car 이름 생성 테스트")
    void createCarWithNameTest() {
        assertThat(car.getName()).isEqualTo("testCar");
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("car객체 이동 횟수 증가 테스트")
    void raiseMoveCountTest() {
        car.raiseMoveCount();
        car.raiseMoveCount();

        assertThat(car.getMoveCount()).isEqualTo(2);
    }
}
