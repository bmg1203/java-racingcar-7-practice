package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        GameController gameController = new GameController(outputView, inputView);

        gameController.run();
    }
}
