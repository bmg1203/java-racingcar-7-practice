package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Cars;
import racingcar.model.game.Game;
import racingcar.model.game.RandomNumberPicker;
import racingcar.model.game.TotalRounds;

public class GameTest {
    private Game game;
    private String[] names;
    private Cars cars;
    private TotalRounds totalRounds;

    @BeforeEach
    void setUp() {
        totalRounds = new TotalRounds(3);
        names = new String[]{"pobi", "woni", "jun"};
        cars = new Cars(names);
        game = new Game(cars, totalRounds, new RandomNumberPicker());
    }

    @Test
    @DisplayName("출전하는 자동차가 2대보다 적은 경우에는 예외를 던진다.")
    void throwExceptionWhenNumberOfCarsIsFewerThanMinimumNumberOfCars() {
        // given
        String[] nameOfCars = new String[]{"pobi"};
        Cars invalidNumberOfCars = new Cars(nameOfCars);

        // when & then
        assertThatThrownBy(() -> new Game(invalidNumberOfCars, totalRounds, new RandomNumberPicker()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 2대 이상 출전해야 합니다.");
    }

    @Test
    @DisplayName("라운드만큼 반복한 뒤에는 isPlaying 이 false 를 반환한다.")
    void shouldReturnFalseAfterTotalRoundsRepetitions() {
        // when
        int i = 1;
        while (totalRounds.hasMoreRoundsThan(i)) {
            game.play();
            i++;
        }

        // then
        assertThat(game.isPlaying()).isFalse();
    }

    @Test
    @DisplayName("라운드만큼 반복하기 이전에는 isPlaying 이 true 를 반환한다.")
    void shouldReturnTrueBeforeTotalRoundsRepetitions() {
        // when
        while (totalRounds.hasMoreRoundsThan(1)) {
            game.play();
            break;
        }

        // then
        assertThat(game.isPlaying()).isTrue();
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차의 이름을 반환한다.")
    void returnNameOfCarWhenItHasMaxPosition() {
        // given
        int indexOfMaxPositionCar = 0;

        cars.move(indexOfMaxPositionCar);
        cars.move(indexOfMaxPositionCar);
        cars.move(indexOfMaxPositionCar);

        // when
        game.judgeWinners();
        List<String> nameOfMaxPositionCars = game.getNameOfWinners();

        // then
        assertAll(
                () -> assertThat(nameOfMaxPositionCars.size()).isEqualTo(1),
                () -> assertThat(nameOfMaxPositionCars.get(indexOfMaxPositionCar)).isEqualTo(
                        names[indexOfMaxPositionCar])
        );
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 여러대일 경우 여러개의 이름을 반환한다.")
    void returnNamesOfCarsWhenTheyHaveMaxPosition() {
        // given
        int indexOfFirstMaxPositionCar = 0;
        int indexOfSecondMaxPositionCar = 1;
        int sizeOfMaxPositionCars = 2;

        cars.move(indexOfFirstMaxPositionCar);
        cars.move(indexOfFirstMaxPositionCar);
        cars.move(indexOfSecondMaxPositionCar);
        cars.move(indexOfSecondMaxPositionCar);

        // when
        game.judgeWinners();
        List<String> nameOfMaxPositionCars = game.getNameOfWinners();

        // then
        assertAll(
                () -> assertThat(nameOfMaxPositionCars.size()).isEqualTo(sizeOfMaxPositionCars),
                () -> assertThat(nameOfMaxPositionCars).isEqualTo(
                        List.of(names[indexOfFirstMaxPositionCar], names[indexOfSecondMaxPositionCar]))
        );
    }
}
