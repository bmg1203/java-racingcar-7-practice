package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final InputView inputView = new InputView();
        final RacingCarController racingCarController = new RacingCarController(inputView);
        racingCarController.run();
    }
}
