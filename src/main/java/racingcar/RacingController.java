package racingcar;


public class RacingController {
    private final InputView inputView;

    public RacingController() {
        this.inputView = new InputView();
    }

    public void run() {
        ConsoleInput consoleInput = inputView.ask();
    }
}
