package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.Car.FORWARDING_CONDITION;

class CarTest {

    Car car, anotherCar;

    @BeforeEach
    void beforeEach() {
        car = new Car("Jihyun");
        anotherCar = new Car("Jihye");
    }

    @Test
    @DisplayName("기준 숫자 이상이면 전진")
    void executeMove() {
        car.execute(FORWARDING_CONDITION);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("기준 숫자 미만이면 정지")
    void executeStay() {
        car.execute(FORWARDING_CONDITION -1);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car 한 대의 현재 상태 문자열 반환 검증")
    void testToString() {
        car.execute(FORWARDING_CONDITION);
        car.execute(FORWARDING_CONDITION);
        assertThat(car.toString()).isEqualTo("Jihyun : --");
    }

    @Test
    @DisplayName("이동 거리가 더 긴 Car가 우선순위 높음")
    void compareDistance() {
        car.execute(FORWARDING_CONDITION);
        car.execute(FORWARDING_CONDITION);
        anotherCar.execute(FORWARDING_CONDITION);
        anotherCar.execute(FORWARDING_CONDITION -1);
        assertThat(car.getDistance()).isEqualTo(2); // car은 이동 거리가 2
        assertThat(anotherCar.getDistance()).isEqualTo(1); // anotherCar은 이동 거리가 1
        assertThat(car.compareDistance(anotherCar)).isNegative();
    }
}