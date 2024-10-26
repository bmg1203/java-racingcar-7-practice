package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatusDto;

import java.util.List;

class RacingCarsTest {

    @Test
    @DisplayName("자동차 이름으로 경주에 참가할 자동차를 등록한다.")
    void registerCars() {
        //given
        List<String> carNames = List.of("kobe", "james", "tim", "curry");
        RacingCars racingCars = new RacingCars();

        //when
        racingCars.registerCars(carNames);
        List<CarStatusDto> status = racingCars.getStatus();

        //then
        for (int i = 0; i < carNames.size(); i++) {
            Assertions.assertThat(status.get(i).getName()).isEqualTo(carNames.get(i));
        }
    }

    @Test
    @DisplayName("부여받은 숫자에 따라, 경주 자동차가 전진하거나 정지 상태를 유지한다.")
    void updatePositionsWithRandomNumbers() {
        //given
        List<String> carNames = List.of("one", "two", "three", "four");
        RacingCars racingCars = new RacingCars();
        racingCars.registerCars(carNames);

        //when
        List<Integer> numbers = List.of(1, 2, 4, 5);
        racingCars.updatePositionsWithRandomNumbers(numbers);

        List<CarStatusDto> status = racingCars.getStatus();
        List<Integer> expectedPositions = List.of(0, 0, 1, 1);
        List<Integer> currentPositions = status.stream()
                .map(CarStatusDto::getPosition)
                .toList();

        //then
        Assertions.assertThat(expectedPositions).hasSameElementsAs(currentPositions);
    }

    @Test
    @DisplayName("경주 자동차의 위치에 따라 우승자를 선정한다.")
    void selectWinners() {
        //given
        List<String> carNames = List.of("java", "go", "ruby", "react");
        RacingCars racingCars = new RacingCars();
        racingCars.registerCars(carNames);

        //when
        List<Integer> numbers = List.of(2, 1, 7, 8);
        racingCars.updatePositionsWithRandomNumbers(numbers);
        List<String> winners = racingCars.selectWinners();
        List<String> expectedWinners = List.of("ruby", "react");

        //then
        Assertions.assertThat(expectedWinners).hasSameElementsAs(winners);
    }

    @Test
    @DisplayName("중복된 자동차 이름을 입력받지 않았는지 테스트한다.")
    void validateUniqueName() {
        //given
        List<String> carNames = List.of("messi", "messi", "james");
        RacingCars racingCars = new RacingCars();

        //when & then
        Assertions.assertThatThrownBy(() -> racingCars.registerCars(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}