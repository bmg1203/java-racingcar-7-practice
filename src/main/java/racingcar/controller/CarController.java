package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class CarController {
    private final int MOVEMENT_STANDARD = 4;

    public void start() {
        OutputView.printCarNameInputMessage();
        CarManager carManager = CarManager.getInstance();
        for(String carName : InputView.readCarNames()) {
            carManager.addCar(new Car(carName));
        }
        OutputView.printTotalAttemptInputMessage();
        carManager.setRemainingAttempts(InputView.readTotalAttempt());
        OutputView.printResultMessage();
        while(carManager.getRemainingAttempts() > 0) {
            carManager.decrementRemainingAttempts();
            race(carManager.getCars());

            OutputView.printCarState(carManager.getCars());

        }
    }
    public boolean canMove() {
        if(Randoms.pickNumberInRange(0,9) >= MOVEMENT_STANDARD) {
            return true;
        }
        return false;
    }

    public void race(List<Car> cars) {
        for(Car car : cars) {
            if(canMove()) {
                car.move();
            }
        }
    }

    public int getMostMovedCar(List<Car> cars) {
        int max = Integer.MIN_VALUE;
        for(Car car : cars) {
            if(max < car.getMovedDistance()) {
                max = car.getMovedDistance();
            }
        }
        return max;
    }

    public List<Car> getWinner(List<Car> cars, int max) {
        List<Car> winners = new ArrayList<>();
        for(Car car : cars) {
            if(car.getMovedDistance() >= max) {
                winners.add(car);
            }
        }
        return winners;
    }
}
