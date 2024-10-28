package racingcar;

import java.util.List;

public class RaceController {
    public void run() {
        List<String> carNames = InputView.inputCarNames();
        List<Car> carList = Cars.createCars(carNames);
        Cars cars = new Cars(carList);
        int tryCount = InputView.inputTryCount();

        System.out.println();
        System.out.println("실행 결과");

        for (int n = 0; n < tryCount; n++) {
            cars.moveAllCars();
            OutputView.printCarStatus(cars);
        }

        List<Car> winner = cars.findWinner();
        OutputView.printWinner(winner);
    }
}
