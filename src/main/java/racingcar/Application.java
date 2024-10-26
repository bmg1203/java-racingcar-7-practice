package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new TryCountValidator());
        OutputView outputView = new OutputView();

        RacingCarController racingCarController = new RacingCarController(inputView, outputView);

        racingCarController.playGame();
    }
}
