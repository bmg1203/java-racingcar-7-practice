package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Number;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String userInput = inputView.CarNamesInput();
        Number attemptsNum = inputView.attemptsNumInput();

        Cars cars = new Cars(makeCarList(userInput));

        startRace(attemptsNum, cars);

        List<String> winnersName = cars.findWinners();
        outputView.showWinners(winnersName);
    }

    private void startRace(Number attemptsNum, Cars cars) {
        outputView.showExecuteMessage();
        for (int attempt = 0; attempt < attemptsNum.value(); attempt++) {
            cars.forwardWithRandomCondition();
            outputView.showStatus(cars);
        }
    }

    private List<Car> makeCarList(String userInput) {
        List<Car> carlist = new ArrayList<>();
        for (String carName : userInput.split(",")) {
            carlist.add(Car.from(carName));
        }

        return carlist;
    }
}
