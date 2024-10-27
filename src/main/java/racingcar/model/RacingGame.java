package racingcar.model;

import java.util.List;

public class RacingGame {
    public static void playRace(List<Car> cars) {
        for (Car car : cars) {
            car.goForward();
        }
    }

    static void playRace(List<Car> cars, int fixedNumberForTest) {
        for (Car car : cars) {
            car.goForward(fixedNumberForTest);
        }
    }
}