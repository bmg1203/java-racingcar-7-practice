package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.validation.ErrorMessage.OVER_MAX_CAR_NAME;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("4 이상 값이 들어왔을 경우, 자동차는 한 칸 이동해야한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move_case_test(int randomNumber) {
        //given
        Car car = new Car("pobi");
        //when
        int moveResult = car.move(randomNumber);
        //then
        assertThat(moveResult).isEqualTo(1);
    }

    @DisplayName("3이하의 값이 랜덤값일 경우, 자동차는 움직이면 안 된다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void not_move_case_test(int randomNumber) {
        //given
        Car car = new Car("pobi");
        //when
        int moveResult = car.move(randomNumber);
        //then
        assertThat(moveResult).isEqualTo(0);
    }

    @DisplayName("4 이상의 값이 3번 주어졌을 때, 자동차는 세 칸 이동해야 한다")
    @Test
    void moves_when_over_four() {
        //given
        Car car = new Car("pobi");
        List<Integer> testList = List.of(4, 5, 6);
        //when
        for (int i = 0; i < testList.size(); i++) {
            car.move(testList.get(i));
        }
        //then
        assertThat(car.getMovedDistance()).isEqualTo(3);
    }

    @DisplayName("3 이하의 값이 3번 주어졌을 때, 자동차의 거리는 0이어야한다")
    @Test
    void moves_when_under_three() {
        //given
        Car car = new Car("pobi");
        List<Integer> testList = List.of(1, 2, 3);
        //when
        for (int i = 0; i < testList.size(); i++) {
            car.move(testList.get(i));
        }
        //then
        assertThat(car.getMovedDistance()).isEqualTo(0);
    }

    @DisplayName("길이가 5인 carName이 주어졌을 때, 성공적으로 car객체가 만들어진다")
    @Test
    void length_5_car_name_then_pass() {
        Car car = new Car("bibim");
    }

    @DisplayName("길이가 6이상인 carName이 주어졌을 때, 예외를 발생시킨다")
    @Test
    void over_6_car_name_then_throw_exception() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("bbibim");
        });
        assertThat(exception.getMessage()).isEqualTo(OVER_MAX_CAR_NAME.getMessage());
    }
}
