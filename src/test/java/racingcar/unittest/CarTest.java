package racingcar.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

class CarTest extends NsTest {

    @Test
    @DisplayName("Car 객체 생성 시 이름이 정상적으로 설정되는지 테스트")
    void createCar_withName_shouldSetName() {
        // Given
        String name = "pobi";

        // When
        Car car = new Car(name);

        // Then
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("Car 객체 생성 시 초기 위치는 0인지 테스트")
    void createCar_initialPosition_shouldBeZero() {
        // Given
        String name = "pobi";

        // When
        Car car = new Car(name);

        // Then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("move 메서드 호출 시 위치가 1 증가하는지 테스트")
    void move_shouldIncreasePositionByOne() {
        // Given
        Car car = new Car("pobi");
        int initialPosition = car.getPosition();

        // When
        car.move();

        // Then
        assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
    }

    @Override
    public void runMain() {
    }
}
