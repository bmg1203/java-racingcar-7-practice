package racingcar.model;

import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.Constant;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingGameModel {

    public List<Car> generateCarsFromNames(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name, Constant.CAR_SCORE_DEFAULT_VALUE))
                .toList();
    }

    public List<String> generateNamesFromCars(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }

    public void attemptMove(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = getRandomNumber();

            if (randomNumber >= Constant.MOVE_THRESHOLD_VALUE) {
                car.move();
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(Constant.MIN_RANDOM_VALUE, Constant.MAX_RANDOM_VALUE);
    }
}
