package racingcar.controller;

import java.util.List;
import racingcar.model.car.Cars;
import racingcar.model.count.TryCount;
import racingcar.model.race.Racing;
import racingcar.model.race.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final TryCount tryCount;
    private final String carNames;

    public RaceController() {
        this.carNames = inputCarNames();
        this.tryCount = initTryCount();
    }

    public void execute() {
        final Cars cars = new Cars(carNames);
        final Racing racing = new Racing(cars);
        OutputView.printResultMessage();
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            runSingleTrial(cars, racing);
        }
        OutputView.printWinner(findWinner(cars));
    }

    private void runSingleTrial(final Cars cars, final Racing racing) {
        racing.start();
        OutputView.printResult(cars);
    }

    private List<String> findWinner(final Cars cars) {
        final Winner winner = new Winner(cars);
        return winner.find();
    }

    private String inputCarNames() {
        try {
            return InputView.inputCarName();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            throw e;
        }
    }

    private TryCount initTryCount() {
        try {
            final String count = InputView.inputTryCount();
            return new TryCount(count);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            throw e;
        }
    }
}
