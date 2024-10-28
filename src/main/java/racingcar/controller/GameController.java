package racingcar.controller;

import racingcar.model.RaceCars;
import racingcar.model.WinningCars;
import racingcar.validate.Validation;
import racingcar.view.InputMessage;
import racingcar.view.OutputMessage;

public class GameController {

    private final RaceCars raceCars;

    public GameController(final RaceCars raceCars) {
        this.raceCars = raceCars;
    }

    public void start() {
        extractCarNames();
        attemptGame();
        resultWinnerList();
    }

    private void extractCarNames() {
        final String input = InputMessage.inputCarNames();
        Validation.validateInput(input);
        raceCars.createCars(input);
    }

    private void attemptGame() {
        final String num = InputMessage.inputGameAttempts();
        final int count = Validation.validateTryGame(num);
        raceCars.executeRounds(count);
    }

    private void resultWinnerList() {
        WinningCars winningCars = new WinningCars(raceCars.getCars());
        final String carNames = winningCars.getWinnerNames();
        OutputMessage.executeResultMessage(carNames);
    }

}
