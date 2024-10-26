package racingcar.domain;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    private final InputView inputView;
    private final OutputView outputView;

    public Race(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        final List<String> carNames = inputView.readCarNames();
        final int attemptCount = inputView.readAttemptCount();
        final Cars cars = new Cars(carNames);

        outputView.printResultMessage();
        for (int count = 0; count < attemptCount; ++count) {
            cars.move();
            cars.get().forEach(outputView::printResult);
        }
    }
}
