package racingcar.controller;

import racingcar.model.Cars;
import racingcar.service.CarCreateService;
import racingcar.service.CarGameService;
import racingcar.view.OutputView;

public class CarGameController {

    private final CarGameService carGameService;
    private final CarCreateService carCreateService;
    private final InputView inputView;
    private final OutputView outputView;

    public CarGameController(CarGameService carGameService, CarCreateService carCreateService,
        InputView inputView, OutputView outputView) {
        this.carGameService = carGameService;
        this.carCreateService = carCreateService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String carNames = getCarNames();
        int rounds = getRounds();
        Cars cars = carCreateService.fromString(carNames);

        Cars winners = carGameService.play(cars, rounds);

        outputView.printWinners(winners);
    }

    private String getCarNames() {
        outputView.requireCarNames();
        return inputView.inputCarNames();
    }

    private int getRounds() {
        outputView.requireRound();
        return inputView.inputRound();
    }

}
