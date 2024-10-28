package racingcar.controller;

import static racingcar.utils.CarNameInputProcessor.splitCarNames;
import static racingcar.utils.TotalRoundsInputProcessor.parseTotalRounds;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.*;
import racingcar.view.*;

public class RacingGameController {
    public void run() {
        List<String> carNames = setCarNames();
        int totalRounds = setTotalRounds();
        Console.close();
        RacingGame racingGame = new RacingGame(carNames);
        playRounds(racingGame, totalRounds);
        printWinners(racingGame);
    }

    List<String> setCarNames() {
        String carNames = InputView.getCarNames();
        return splitCarNames(carNames);
    }

    int setTotalRounds() {
        String totalRounds = InputView.getTotalRounds();
        return parseTotalRounds(totalRounds);
    }

    void playRounds(RacingGame racingGame, int moveCount) {
        OutputView.printExecutionText();
        for (int i = 0; i < moveCount; i++) {
            List<Car> cars = racingGame.move();
            OutputView.printCarsPosition(cars);
            System.out.println();
        }
    }

    void printWinners(RacingGame racingGame) {
        int maxMoveCount = racingGame.getMaxPosition();
        List<String> winners = racingGame.getWinners(maxMoveCount);
        OutputView.printFinalWinners(winners);
    }
}
