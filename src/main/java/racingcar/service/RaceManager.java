package racingcar.service;


import racingcar.domain.Car;
import racingcar.view.OutputView;

import java.util.List;

public class RaceManager {
    private final List<Car> cars;
    private final int round;

    public RaceManager(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRound() {
        return round;
    }

    public void playAllRounds(OutputView outputView) {
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            playSingleRound();
            outputView.displayRoundResults(cars);
            System.out.println();
        }
    }

    private void playSingleRound() {
        for (Car car : cars) {
            car.attemptMoveForward();
        }
    }
}
