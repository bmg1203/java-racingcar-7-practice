package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("공백 이름 테스트 ")
    public void validationEmptyNameTest() {
        //given
        String name = "";
        //expected
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }
    @Test
    @DisplayName("car 이름 크기 테스트")
    public void validationNameLengthTest() {
        //given
        String name1 = "test";
        String name2 = "abcdef";
        //expect
        Car car = new Car(name1);
        assertThat(car.getName()).isEqualTo(name1);
        assertThrows(IllegalArgumentException.class, () -> new Car(name2));
    }
}