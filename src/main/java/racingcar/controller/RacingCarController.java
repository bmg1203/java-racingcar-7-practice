package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.model.RacingGame;
import racingcar.view.RacingCarView;

public class RacingCarController {

    RacingCarView view = new RacingCarView();
    RacingCars racingCars = new RacingCars();

    public void raceStart() {

        String inputCarNames = view.inputCarNames();
        for (final String carName : inputCarNames.split(",")) {
            racingCars.add(new Car(carName));
        }

        int tryNum = Integer.parseInt(view.inputTryNumber());

        RacingGame racingGame = new RacingGame(racingCars, tryNum);
    }
}
