package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.io.InputConsoleHandler;
import racingcar.io.OutputConsoleHandler;
import racingcar.provider.LinearIncrementalNumberProvider;
import racingcar.provider.NumberProvider;
import racingcar.provider.RandomNumberProvider;

class RacingGameTest {

    @Test
    @DisplayName("각 차수마다 자동차들의 위치 상태를 출력한다")
    void showCarVisualStatusForEachTrialTest() {
        // given
        RacingGame racingGame = new RacingGame(new RandomNumberProvider(),
                new InputConsoleHandler(), new OutputConsoleHandler());
        Car t1 = Car.from("t1");
        Car t2 = Car.from("t2");
        Car t3 = Car.from("t3");

        t1.tryMoveForward(3, 1);
        t2.tryMoveForward(4, 1);
        t3.tryMoveForward(4, 1);

        Cars cars = Cars.from(Arrays.asList(t1, t2, t3));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        // when
        racingGame.showCarsPositionalStatusForEachTrial(cars);

        // then
        assertThat(byteArrayOutputStream.toString()).isEqualTo(
                "t1 : " + System.lineSeparator() + "t2 : -" + System.lineSeparator() + "t3 : -"
                        + System.lineSeparator() + System.lineSeparator()
        );

        System.setOut(System.out);
    }

    @Test
    @DisplayName("최종 우승자를 출력한다")
    void showSingleWinnerName() {
        // given
        RacingGame racingGame = new RacingGame(new LinearIncrementalNumberProvider(1, 2),
                new InputConsoleHandler(), new OutputConsoleHandler());

        Cars cars = Cars.of("test1", "test2", "test3");
        NumberProvider numberProvider = new LinearIncrementalNumberProvider(1, 2);
        cars.tryMoveForward(numberProvider);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        // when
        racingGame.showWinners(cars);

        // then
        assertThat(byteArrayOutputStream.toString()).isEqualTo("최종 우승자 : test3" + System.lineSeparator());
        System.setOut(System.out);
    }

    @Test
    @DisplayName("두 명 이상의 최종 우승자를 출력한다")
    void showWinneNames() {
        // given
        RacingGame racingGame = new RacingGame(new LinearIncrementalNumberProvider(3, 2),
                new InputConsoleHandler(), new OutputConsoleHandler());

        Cars cars = Cars.of("test1", "test2", "test3");
        cars.tryMoveForward(new LinearIncrementalNumberProvider(3, 2));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        // when
        racingGame.showWinners(cars);

        // then
        assertThat(byteArrayOutputStream.toString()).isEqualTo("최종 우승자 : test2,test3" + System.lineSeparator());
        System.setOut(System.out);
    }

}