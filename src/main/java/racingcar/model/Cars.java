package racingcar.model;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        List<String> trimmedCarNames = trimCarNames(carNames);
        validateCarNames(trimmedCarNames);
        for (String name : trimmedCarNames) {
            cars.add(new Car(name));
        }
    }

    private List<String> trimCarNames(List<String> carNames) {
        List<String> trimmedNames = new ArrayList<>();
        for (String name : carNames) {
            trimmedNames.add(name.trim());
        }
        return trimmedNames;
    }

    private void validateCarNames(List<String> carNames) {
        HashSet<String> uniqueNames = new HashSet<>();
        for (String name : carNames) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름이 비어 있으면 안됩니다.");
            }
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("동일한 자동차 이름이 중복될 수 없습니다.");
            }
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> collectProgressVisualizations() {
        List<String> CarProgressVisualizations = new ArrayList<>();
        for (Car car : cars) {
            CarProgressVisualizations.add(car.visualizeProgress());
        }
        return CarProgressVisualizations;
    }

    public List<String> calculateWinners() {
        int maxProgress = cars.stream()
                .mapToInt(Car::getProgress)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getProgress() == maxProgress)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
