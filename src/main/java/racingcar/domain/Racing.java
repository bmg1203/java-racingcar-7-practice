package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {

    private final List<Car> cars;

    public Racing(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> move() {
        for (Car car : cars) {
            car.go(1);
        }
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners() {
        final long maxScore = getMaxScore();
        return cars.stream()
                .filter(car -> car.isWinner(maxScore))
                .toList();
    }

    private long getMaxScore() {
        return cars.stream()
                .mapToLong(Car::getScore)
                .max()
                .orElse(0L);
    }

}
