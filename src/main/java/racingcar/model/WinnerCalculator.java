package racingcar.model;

import java.util.List;

public class WinnerCalculator {
    public static List<String> calculateWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName).toList();
    }
}
