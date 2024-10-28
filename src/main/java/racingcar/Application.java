package racingcar;

import racingcar.controller.RaceController;
import racingcar.controller.validator.UserInputValidator;
import racingcar.model.GameService;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInputValidator userInputValidator = new UserInputValidator();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameService gameService = new GameService();

        RaceController racingGame = new RaceController(inputView, outputView, gameService, userInputValidator);
        racingGame.playGame();
    }
}