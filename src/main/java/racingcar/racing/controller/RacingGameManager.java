package racingcar.racing.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.racing.model.Car;
import racingcar.racing.model.RacingGame;
import racingcar.racing.model.dto.RoundResult;
import racingcar.racing.utils.InputParser;
import racingcar.racing.utils.InputValidator;
import racingcar.racing.view.InputView;
import racingcar.racing.view.OutputView;

public class RacingGameManager {
    private RacingGame game;

    public void run() {
        List<String> carNames = getCarNames();
        int attemptNumber = getAttemptNumber();
        createRacingGame(attemptNumber, carNames);
        List<List<RoundResult>> allRoundResult = game.start();
        OutputView.printAllRoundResult(allRoundResult);
        List<Car> winners = game.selectWinners();
        OutputView.printWinner(winners);
        Console.close();
    }

    private void createRacingGame(int attemptNumber, List<String> carNames) {
        this.game = RacingGame.of(attemptNumber, carNames);
    }

    private int getAttemptNumber() {
        String inputAttemptNumber = InputView.inputConsole("시도할 횟수는 몇 회인가요?");
        InputValidator.validateInputNotEmpty(inputAttemptNumber);
        int attemptNumber = InputParser.parseAttemptNumber(inputAttemptNumber);
        InputValidator.validateAttemptNumber(attemptNumber);
        return attemptNumber;
    }

    private List<String> getCarNames() {
        String inputCar = InputView.inputConsole("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        InputValidator.validateInputNotEmpty(inputCar);
        List<String> carNames = InputParser.parseCarNames(inputCar);
        InputValidator.validateCarNameLength(carNames);
        InputValidator.validateCarArrayNotEmpty(carNames);
        return carNames;
    }
}
