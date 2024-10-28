package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarStatus {
    private final WinnerFinder winnerFinder;
    private final List<Car> cars;

    public CarStatus(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.winnerFinder = new WinnerFinder();
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    public List<String> getCarNames() {
        return cars.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public List<Integer> getCarPositions() {
        return cars.stream()
                .map(Car::getCarPosition)
                .collect(Collectors.toList());
    }

    public List<String> getWinners() {
        return winnerFinder.findWinners(cars);
    }

    public void playOneRound() {
        moveCars();
    }
}