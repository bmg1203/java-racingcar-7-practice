package racingcar.model;

import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    private Cars(List<String> carNames) {
        validateCarNamesEmpty(carNames);
        this.cars = carNames.stream()
                .map(Car::create)
                .toList();
    }

    public static Cars apply(List<String> carNames) {
        return new Cars(carNames);
    }

    private void validateCarNamesEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void playARound() {
        for (Car car : cars) {
            moveOrNot(car);
        }
    }

    private void moveOrNot(Car car) {
        if (car.pickRandomNumber() >= 4) {
            car.moveForward();
        }
    }

    public List<String> findWinners() {
        return cars.stream()
                .filter(car -> car.isSameLocation(findWinnerLocation()))
                .map(Car::getName)
                .toList();
    }

    private int findWinnerLocation() {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }

    public List<String> getStatus() {
        return cars.stream()
                .map(Car::makeStatusResult)
                .toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cars cars1)) return false;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }
}
