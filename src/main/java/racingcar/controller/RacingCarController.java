package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.model.GameResult;
import racingcar.service.GameRunner;
import racingcar.service.GameSetup;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameSetup racingCarService;
    private final GameRunner gameRunner;

    public RacingCarController(InputView inputView, OutputView outputView, GameSetup racingCarService, GameRunner gameRunner) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
        this.gameRunner = gameRunner;
    }

    public void initializeGame() {
        List<String> carNames = splitCarNames();
        int attemptCount = parseAttemptCount();

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        Game game = new Game(cars, attemptCount);

        startGame(game);
    }

    public List<String> splitCarNames() {
        String carNameList = inputView.getCarName();
        return racingCarService.splitCarName(carNameList);
    }

    public int parseAttemptCount() {
        String attemptCount = inputView.getAttemptCount();
        return racingCarService.parseAttemptCount(attemptCount);
    }

    public void startGame(Game game) {
        GameResult gameResult = gameRunner.runGame(game.getCars(), game.getAttemptCount());
        outputView.showRoundResult(gameResult.getAllRoundResults());
        showResult(gameResult.getFinalCarState());
    }

    public void showResult(List<Car> cars) {
        String winners = gameRunner.getWinner(cars);
        outputView.showWinners(winners);
    }
}
