package racingcar.controller;

import racingcar.model.GameTryCount;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;
import racingcar.model.RacingCarName;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void initCarName() {
        String inputCarName = inputView.inputCarName();
        RacingCarName racingCarName = new RacingCarName(inputView.splitCarName(inputCarName));
        RacingCarList racingCarList = new RacingCarList();

        for (String name : racingCarName.getList()) {
            racingCarList.add(new RacingCar(name));
        }
    }

    public void initTryCount() {
        String inputTryCount = inputView.inputTryCount();
        GameTryCount.set(inputView.convertStringToInt(inputTryCount));
    }

    public void startGame() {
        initCarName();
        initTryCount();
    }

    public String findWinner() {
        final Winner winner = new Winner();
        return winner.getList(RacingCarList.get(), winner.maxPosition(RacingCarList.get()));
    }

    private void endGame() {
        outputView.printInitResult();
        outputView.printRoundResult();
        outputView.printEndResult(findWinner());
    }

    public void run() {
        startGame();
        endGame();
        inputView.close();
    }
}
