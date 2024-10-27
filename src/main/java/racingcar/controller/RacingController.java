package racingcar.controller;

import java.util.HashMap;
import racingcar.service.CarService;
import racingcar.service.RacingService;
import racingcar.view.InputView;

public class RacingController {

    private final InputView inputView;
    private final CarService carService;
    private final RacingService racingService;

    public RacingController(InputView inputView, CarService carService, RacingService racingService) {
        this.inputView = inputView;
        this.carService = carService;
        this.racingService = racingService;
    }

    public void startRacing() {
        String carNames = inputView.inputCarNames();

        HashMap<String, Integer> cars = carService.splitCarNames(carNames);

        String inputAttemptCount = inputView.inputAttemptCount();

        int attemptCount = racingService.parseAttemptCount(inputAttemptCount);
    }
}
