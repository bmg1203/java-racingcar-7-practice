package racingcar.game;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.game.exception.GamePlayersException.MaximumPlayersExceededException;
import racingcar.game.exception.GamePlayersException.MinimumPlayersRequiredException;
import racingcar.game.exception.GameRoundException.MaximumGameRoundExceededException;
import racingcar.game.exception.GameRoundException.MinimumGameRoundRequiredException;

class RacingCarGameTest {

    @Test
    void createRacingCarGame_게임횟수그리고자동차들입력받으면_생성한다(){
        // given
        final int roundCount = 3;

        final Car car1 = Car.createNamedCar();
        final Car car2 = Car.createNamedCar();
        final List<Car> cars = List.of(car1, car2);

        // expect
        assertThatCode(() -> RacingCarGame.createLoopedRacingCarGame(roundCount,cars))
                .doesNotThrowAnyException();
    }
    @Test
    void createRacingCarGame_자동차최대5대초과시_예외처리(){
        // given
        final int roundCount = 3;

        final Car car1 = Car.createNamedCar();
        final Car car2 = Car.createNamedCar();
        final Car car3 = Car.createNamedCar();
        final Car car4 = Car.createNamedCar();
        final Car car5 = Car.createNamedCar();
        final Car car6 = Car.createNamedCar();
        final List<Car> fiveOverCars = List.of(car1, car2,car3,car4,car5,car6);

        // expect
        assertThatThrownBy(()->RacingCarGame.createLoopedRacingCarGame(roundCount,fiveOverCars))
                .isInstanceOf(MaximumPlayersExceededException.class)
                .hasMessage("최대 5명까지 게임 시작 가능합니다.");
    }

    @Test
    void createRacingCarGame_자동차최소2대미만시_예외처리(){
        // given
        final int roundCount = 3;

        final Car car1 = Car.createNamedCar();
        final List<Car> oneCar = List.of(car1);

        // expect
        assertThatThrownBy(()->RacingCarGame.createLoopedRacingCarGame(roundCount,oneCar))
                .isInstanceOf(MinimumPlayersRequiredException.class)
                .hasMessage("최소 2명부터 게임 시작 가능합니다.");
    }

    @Test
    void createRacingCarGame_게임횟수1번미만시_예외처리(){
        // given
        final int lessThanGAME_MINIMUM_ROUND = 0;
        final Car car1 = Car.createNamedCar();
        final Car car2 = Car.createNamedCar();
        final List<Car> cars = List.of(car1,car2);

        // expect
        assertThatThrownBy(()-> RacingCarGame.createLoopedRacingCarGame(lessThanGAME_MINIMUM_ROUND,cars))
                .isInstanceOf(MinimumGameRoundRequiredException.class)
                .hasMessage("최소 1번부터 게임 시작 가능합니다");
    }

    @Test
    void createRacingCarGame_게임횟수100번초과시_예외처리(){
        // given
        final int overThanGAME_MAXIMUM_ROUND = 101;
        final Car car1 = Car.createNamedCar();
        final Car car2 = Car.createNamedCar();
        final List<Car> cars = List.of(car1,car2);

        // expect
        assertThatThrownBy(()-> RacingCarGame.createLoopedRacingCarGame(overThanGAME_MAXIMUM_ROUND,cars))
                .isInstanceOf(MaximumGameRoundExceededException.class)
                .hasMessage("최대 100번까지 게임 시작 가능합니다");
    }



}