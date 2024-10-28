package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @DisplayName("자동차를 생성한다.")
    @Test
    void createCar() {
        //given
        Car car = Car.from("pobi");
        //when
        //then
        assertThat(car)
            .extracting("name", "position.value")
            .containsExactlyInAnyOrder("pobi", 0);
    }

    @DisplayName("자동차의 이름은 5글자 이하여야 한다.")
    @Test
    void carNameIsUnderLength() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Car.from("나는여섯글자"))
            .withMessage("이름은 5자 이하여야 합니다.");
    }

    @DisplayName("4 이상의 값을 받으면 자동차는 이동한다.")
    @Test
    void moveCar() {
        //given
        Car car = Car.from("pobi");
        //when
        car.move(4);
        //then
        assertThat(car)
            .extracting("name", "position.value")
            .containsExactlyInAnyOrder("pobi", 1);
    }

    @DisplayName("4 미만의 값을 받으면 자동차는 이동하지 않는다.")
    @Test
    void stayCar() {
        //given
        Car car = Car.from("pobi");
        //when
        car.move(3);
        //then
        assertThat(car)
            .extracting("name", "position.value")
            .containsExactlyInAnyOrder("pobi", 0);
    }

    @DisplayName("현재 위치와 비교 위치가 다르면 true를 반환한다.")
    @Test
    void isNotSamePosition() {
        //given
        Car car = Car.from("pobi");
        //when
        boolean status = car.isNotSamePositionTo(1);
        //then
        assertThat(status).isTrue();
    }

    @DisplayName("현재 위치와 비교 위치가 같으면 false를 반환한다.")
    @Test
    void isSamePosition() {
        //given
        Car car = Car.from("pobi");
        //when
        boolean status = car.isNotSamePositionTo(0);
        //then
        assertThat(status).isFalse();
    }

}