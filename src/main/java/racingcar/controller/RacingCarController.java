package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class RacingCarController {
    public void run() {
        Cars cars = getCars();
        RaceCount raceCount = getRaceCount();

        playRace(raceCount, cars);

        judgeWinnerCars(cars);
    }

    public Cars getCars() {
        OutputView.requestForCarNames();
        List<String> inputCarNames = InputView.responseForCarNames();
        return createCars(inputCarNames);
    }

    public Cars createCars(List<String> inputCarNames) {
        List<Car> cars = new ArrayList<>();
        inputCarNames.forEach(name -> {
            Car car = new Car(name);
            cars.add(car);
        });
        return new Cars(cars);
    }

    public RaceCount getRaceCount() {
        OutputView.requestForRaceCount();
        int raceCount = InputView.responseForRaceCount();
        return new RaceCount(raceCount);
    }

    public void playRace(RaceCount raceCount, Cars cars) {
        OutputView.displayRaceResult();
        for (int round = 0; round < raceCount.getRaceCount(); round++) {
            cars.move();
            OutputView.displayRoundResult(cars);
        }
    }

    public void judgeWinnerCars(Cars cars) {
        Cars winnerCars = cars.judgeWinnerCars();
        OutputView.displayWinner(winnerCars);
    }
}