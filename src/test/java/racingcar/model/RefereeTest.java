package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.validator.ErrorMessage.EXCEPTION_INT_RANGE;
import static racingcar.util.validator.ErrorMessage.EXCEPTION_NUMBER_RANGE;
import static racingcar.util.validator.ErrorMessage.EXCEPTION_NUMERIC;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    @Test
    @DisplayName("1회 이상 라운드를 입력하지 않으면 예외를 발생시킨다.")
    void shouldThrowExceptionWhenRoundIsLessThanOne() {

        assertThatThrownBy(() -> new Referee("0"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(EXCEPTION_NUMBER_RANGE.message);
    }

    @Test
    @DisplayName("자연수를 입력하지 않으면 예외를 발생시킨다.")
    void shouldThrowExceptionWhenRoundIsNotNaturalNumber() {

        assertThatThrownBy(() -> new Referee("1.1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(EXCEPTION_NUMERIC.message);
    }

    @Test
    @DisplayName("int 범위보다 큰 값을 입력하면 예외를 발생시킨다.")
    void shouldThrowExceptionWhenRoundExceedsIntRange() {

        assertThatThrownBy(() -> new Referee("33333333333"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(EXCEPTION_INT_RANGE.message);
    }

    @Test
    @DisplayName("한 명의 우승자를 판단할 수 있다.")
    void judgmentWinner() {
        // given
        String roundNumber = "1";
        Referee referee = new Referee(roundNumber);
        Cars cars = new Cars(Arrays.asList("우테코", "인호", "페어"));

        cars.getCars().get(0).carMove(4);
        cars.getCars().get(1).carMove(2);
        cars.getCars().get(2).carMove(1);

        // when
        List<Car> winnerCars = referee.judgementWinnerCars(cars);

        // then
        assertThat(winnerCars.get(0)).isEqualTo(cars.getCars().get(0));
    }

    @Test
    @DisplayName("두 명의 우승자를 판단할 수 있다.")
    void judgmentTwoWinners() {
        // given
        String roundNumber = "1";
        Referee referee = new Referee(roundNumber);
        Cars cars = new Cars(Arrays.asList("우테코", "인호", "페어"));

        cars.getCars().get(0).carMove(4);
        cars.getCars().get(1).carMove(4);
        cars.getCars().get(2).carMove(2);

        // when
        List<Car> winnerCars = referee.judgementWinnerCars(cars);

        // then
        assertThat(winnerCars)
                .containsExactlyInAnyOrder(cars.getCars().get(0), cars.getCars().get(1)); // 소정과 인호가 우승자인지 확인
    }
}
