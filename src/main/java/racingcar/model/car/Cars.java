package racingcar.model.car;

import static java.util.Objects.requireNonNull;
import static racingcar.common.message.ErrorMessage.SHOULD_NOT_BE_NULL;

import java.util.List;
import racingcar.model.position.Distance;
import racingcar.model.race.Lap;

public class Cars {
    private final List<Car> cars;

    // Constructor
    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(final List<Car> cars) {
        validateIsNotNull(cars);
        return new Cars(cars);
    }

    // Method
    public void move() {
        for (Car car : cars) {
            Distance distance = car.movableDistance();
            Lap countDownAmount = Lap.ONE;
            if (distance.isBiggerThanZero()) {
                car.updateProgress(distance, countDownAmount);
            }
        }
    }

    public List<String> currentPositions() {
        return cars.stream()
                .map(Car::myProgressSummary)
                .toList();
    }

    public List<Car> filterCompletedAllLap() {
        return cars.stream()
                .filter(Car::completedAllLap)
                .toList();
    }

    // Validation
    private static void validateIsNotNull(final List<Car> cars) {
        cars.forEach(car -> requireNonNull(car, SHOULD_NOT_BE_NULL));
    }
}
