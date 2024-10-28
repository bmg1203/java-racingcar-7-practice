package racingcar.domain;

import racingcar.util.NameParser;
import racingcar.util.RandomDigitGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final NameParser nameParser;
    private final RandomDigitGenerator randomDigitGenerator;
    private Cars cars;
    private int tryCount;

    public RacingGame() {
        this.inputView = new InputView();
        this.nameParser = new NameParser();
        this.randomDigitGenerator = new RandomDigitGenerator();
        this.outputView = new OutputView();
    }

    public void run() {
        createCars();

        tryCount = inputView.tryCount();

        RacingGameController controller =
                new RacingGameController(cars, tryCount, randomDigitGenerator, outputView);
        controller.playGame();

        calculateWinner(controller);
    }

    private void createCars() {
        String carName = inputView.carName();
        List<String> carNames = nameParser.parseCarNames(carName);
        cars = new Cars(carNames);
    }

    private void calculateWinner(RacingGameController controller) {
        List<String> winner = controller.getWinner();
        outputView.printWinners(winner);
    }
}
