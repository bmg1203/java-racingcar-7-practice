package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private final Car car = new Car("testCar");

    @Test
    @DisplayName("자동차 이동 테스트")
    public void testCarIncreaseDistance() {
        car.increaseDistance();
        assertEquals("-", car.getDistance());

        car.increaseDistance();
        assertEquals("--", car.getDistance());

        car.increaseDistance();
        car.increaseDistance();
        assertEquals("-----", car.getDistance());
    }
}
