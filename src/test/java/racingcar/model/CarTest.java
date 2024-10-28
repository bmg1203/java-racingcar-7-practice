package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    /** 테스트 클래스 명 -> [메서드 명]_[테스트 중 상태]_[기대 행위] **/
    @Test
    @DisplayName("자동차 생성 시 이름이 올바르게 설정되는지 테스트")
    void Car_InputtedCarName_gotCorrectlySetCar() {
        // given
        String name = "Ahn";
        int defaultPosition = 0;

        // when
        Car car = new Car(name);

        // then
        assertThat(name).isEqualTo(car.getName());
        assertThat(defaultPosition).isEqualTo(car.getPosition());
    }

    @Test
    @DisplayName("Movement.GO 또는 Movement.STOP 을 받았을 경우 자동차 위치 변화 테스트")
    void move_InputtedMovementGo_movedPosition() {
        // given
        String name = "Ahn";
        int movingPosition = 1;
        int stopPosition = 0;

        Car car1 = new Car(name);
        Car car2 = new Car(name);

        // when
        car1.move(Movement.GO);
        car2.move(Movement.STOP);

        // then
        assertThat(movingPosition).isEqualTo(car1.getPosition());
        assertThat(stopPosition).isEqualTo(car2.getPosition());
    }

    @Test
    @DisplayName("toString 사용 시 자동차 이름 및 위치 출력 테스트")
    void toString_MethodCall_printedCarNameAndPosition() {
        // given
        String name = "Ahn";
        String expectedMessage = "Ahn : -";

        Car car = new Car(name);
        car.move(Movement.GO);

        // when
        String toString = car.toString();

        // then
        assertThat(toString).isEqualTo(expectedMessage);
    }
}
