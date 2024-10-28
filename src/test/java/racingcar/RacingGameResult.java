package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

@DisplayName("자동차 경주 결과 테스트")
public class RacingGameResult {
    @Test
    @DisplayName("제일 멀리 주행한 자동차가 우승한다.")
    void 자동차_경주_우승_테스트() {
        // given
        Cars cars = Cars.createCarsFrom("yoon,yoo,biny", () -> true);
        List<Car> carList = cars.getCars();

        // when
        carList.get(0).move(() -> true);
        carList.get(1).move(() -> false);
        carList.get(2).move(() -> true);

        // then
        List<String> winners = cars.findWinners();
        assertThat(winners).containsExactly("yoon", "biny");
    }
}
