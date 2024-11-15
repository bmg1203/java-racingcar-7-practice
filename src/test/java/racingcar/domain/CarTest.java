package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 정상_생성자_테스트() {
        //given
        String name = "pobi";

        //when
        Car car = new Car(name);

        //then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 이름의_길이가_5이상인_예외_테스트() {
        //given
        String name = "water";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 거리_증가_테스트() {
        //given
        String name = "pobi";
        Car car = new Car(name);

        //when
        car.plusDistance(5);

        //then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void 거리_미증가_테스트() {
        //given
        String name = "pobi";
        Car car = new Car(name);

        //when
        car.plusDistance(3);

        //then
        assertThat(car.getDistance()).isEqualTo(0);
    }
}