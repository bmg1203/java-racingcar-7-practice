package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static racingcar.utils.CarErrorMessage.*;

public class CarServiceTest {

    private final CarService carService = new CarService();

    @Test
    @DisplayName("자동차 이름이 정상적으로 쉼표로 구분되어 리스트로 반환되는지 테스트")
    void testFindCarsSuccessfully() {

        String input = "uni,jini,huni";

        List<String> carNames = carService.processCarNames(input);

        assertThat(carNames).containsExactly("uni", "jini", "huni");
    }

    @Test
    @DisplayName("자동차 이름이 아예 비어있을 때 IllegalArgumentException이 발생하는지 테스트")
    void testEmptyInputThrowsException() {

        String input = "";

        assertThatThrownBy(() -> carService.processCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_OR_EMPTY_CAR_NAMES);
    }

    @Test
    @DisplayName("자동차 이름 중 하나라도 비어있으면 IllegalArgumentException이 발생하는지 테스트")
    void testEmptyCarNameThrowsException() {

        String input = "uni,,huni";


        assertThatThrownBy(() -> carService.processCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_OR_EMPTY_CAR_NAME);
    }

    @Test
    @DisplayName("자동차 이름이 5자 이상일 때 IllegalArgumentException이 발생하는지 테스트")
    void testCarNameLongThrowsException() {

        String input = "uniiiii,huni";


        assertThatThrownBy(() -> carService.processCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_TOO_LONG);
    }
}
