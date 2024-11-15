package racingcar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.constants.OutputPrompts;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private Cars cars;
    private RacingGame racingGame;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        input();
        racing();
        result();
    }

    private void input() {
        List<String> names = inputView.inputCarNames();
        int tryCount = inputView.inputTryCount();

        carsSetting(names);
        racingGame = new RacingGame(cars, tryCount);
    }

    private void carsSetting(List<String> names) {
        Map<String, Car> setCars = new HashMap<>();

        for (String name : names) {
            setCars.put(name, new Car(name));
        }

        cars = new Cars(setCars);
    }

    private void racing() {
        System.out.println("\n" + OutputPrompts.TRY_RESULT_HEADER.getOutputPrompt());
        for (int i = 0; i < racingGame.getTryCount(); i++) {
            for (Car car : racingGame.getCars().getCars().values()) {
                int randomNumber = racingGame.getRandomNumber();
                racingGame.execute(car.getName(), randomNumber);
            }
            outputView.tryResultPrint(cars);
        }
    }

    private void result() {
        Winner winner = new Winner();
        List<String> winners = winner.getWinners(cars);
        outputView.winnersPrint(winners);
    }
}
