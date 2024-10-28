package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void 출력_테스트() {
        Car car = new Car("test");

        Assertions.assertThat(car.toDto().toString()).isEqualTo("test : \n");
    }

    @Test
    public void 랜덤_전진_테스트() {
        Car car = new Car("test");

        car.attemptMove();

        Assertions.assertThat(car.toDto().position()).isIn(0, 1);
    }
}
