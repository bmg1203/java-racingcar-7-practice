package racingcar.controller;

import java.util.LinkedHashMap;
import racingcar.model.CarNameExtractor;
import racingcar.model.GameManager;
import racingcar.model.ResultChecker;
import racingcar.model.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String carName = getCarName();
        Integer rounds = getRounds();
        validateInput(carName, rounds);
        LinkedHashMap<String, Integer> gameEntry = getGameEntry(carName);
        gameEntry = playGame(gameEntry, rounds);
        endGame(gameEntry);
    }

    private String getCarName() {
        outputView.printFirstInitialMessage();
        return inputView.getCarName();
    }

    private Integer getRounds() {
        outputView.printSecondInitialMessage();
        return inputView.getRounds();
    }

    private void validateInput(String carName, Integer rounds) {
        Validator validator = new Validator();
        validator.validateInput(carName, rounds);
    }

    private LinkedHashMap<String, Integer> getGameEntry(String carName) {
        CarNameExtractor carNameExtractor = new CarNameExtractor();
        return carNameExtractor.setGameEntry(carName);
    }

    private LinkedHashMap<String, Integer> playGame(LinkedHashMap<String, Integer> gameEntry, Integer rounds) {
        GameManager gameManager = new GameManager();
        outputView.printPlayMessage();

        while (rounds > 0) {
            gameEntry = gameManager.gameProgress(gameEntry);
            outputView.printRoundResult(gameEntry);
            rounds--;
        }
        return gameEntry;
    }

    private void endGame(LinkedHashMap<String, Integer> gameEntry) {
        ResultChecker resultChecker = new ResultChecker();
        outputView.printWinnerMessage(resultChecker.checkResult(gameEntry));
    }
}
