package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CareTaker;
import racingcar.model.Game;
import racingcar.parser.InputParser;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RepeatCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CareTaker careTaker;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.careTaker = new CareTaker();
    }

    public void play() {
        List<Car> cars = initializeCars();
        int repeatCount = initializeRepeatCount();

        Game game = startGame(repeatCount, cars);

        displayResults(game);
    }

    private List<Car> initializeCars() {
        String carNames = inputView.getCarNamesInput();
        CarNameValidator.validate(carNames);
        return InputParser.parseCars(carNames);
    }

    private int initializeRepeatCount() {
        String repeatCountInput = inputView.getRepeatCountInput();
        RepeatCountValidator.validate(repeatCountInput);
        return InputParser.parseRoundCount(repeatCountInput);
    }

    private Game startGame(int repeatCount, List<Car> cars) {
        Game game = new Game(repeatCount, cars);
        game.playAllRounds(careTaker);
        return game;
    }

    private void displayResults(Game game) {
        outputView.printExeResult(careTaker);
        outputView.printWinner(game.getWinner());
    }
}
