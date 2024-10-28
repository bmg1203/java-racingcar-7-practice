package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.iohandler.InputHandler;
import racingcar.iohandler.OutputHandler;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Car.createCar;
import static racingcar.WinnerSelector.calculateWinners;

public class RacingGame {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {

        outputHandler.showCarNamesInputComments();
        String[] carNames = inputHandler.getCarNamesFromUser();
        List<Car> cars = createCarsFrom(carNames);

        outputHandler.showMoveCountInputComments();
        int moveCount = inputHandler.getMoveCountFromUser();

        showCarProceedScores(moveCount, cars);

        List<String> winners = calculateWinners(cars);
        outputHandler.showWinners(winners);
    }

    private List<Car> createCarsFrom(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            Car car = createCar(name);
            cars.add(car);
        }
        return cars;
    }

    private void showCarProceedScores(int moveCount, List<Car> cars) {
        outputHandler.showCarProceedComments();
        for (int i = 0; i < moveCount; i++) {
            calculateProceedScore(cars);
            outputHandler.showNewLine();
        }
    }

    private void calculateProceedScore(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            int proceedScore = car.proceed(randomNumber);
            outputHandler.showCarProceedScore(car, proceedScore);
        }
    }
}
