package racingcar;

import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carNames = inputView.getCarNames();
        String attemptValue = inputView.getAttemptValue();
        inputView.closeConsole();
    }
}
