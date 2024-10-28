package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {
    private final InputView inputView;
    private final ResultView resultView;

    public RacingGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Cars cars = new Cars(inputView.inputCarNameGuide());
        int round = inputView.inputRound();
        resultView.printResult();
        for (int i = 0; i < round; i++) {
            playRound(cars);
        }
        resultView.printWinners(cars.getWinners());
    }

    private void playRound(Cars cars) {
        cars.tryMove(RandomNumberGenerator.randomNumberGenerator());
        resultView.printAllLocations(cars);
    }

}
