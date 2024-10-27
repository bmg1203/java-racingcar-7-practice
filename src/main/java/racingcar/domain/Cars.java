package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final String DUPLICATE_CAR_NAME_MASSAGE = "자동차 이름은 중복될 수 없습니다.";

    private final List<Car> carList;

    public Cars(List<Car> cars) {
        this.carList = cars;
    }

    public static Cars from(List<String> carNames) {
        validate(carNames);
        List<Car> cars = getCarList(carNames);
        return new Cars(cars);
    }

    private static List<Car> getCarList(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    private static void validate(List<String> carNames) {
        if (isDuplicate(carNames)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MASSAGE);
        }
    }

    private static boolean isDuplicate(List<String> carNames) {
        return carNames.stream().distinct().count() != carNames.size();
    }

    public void move(NumberGenerator numberGenerator) {
        for (Car car : carList) {
            car.move(numberGenerator.generate());
        }
    }

    public List<Integer> getPositions() {
        return carList.stream()
                .map(Car::getPosition)
                .toList();
    }

    public List<Car> getCarList() {
        return new ArrayList<>(carList);
    }

    public List<String> getWinners() {
        Car winner = getWinner();
        return getWinners(winner);
    }

    private Car getWinner() {
        return carList.stream()
                .max(Car::compareTo)
                .get();
    }

    private List<String> getWinners(Car winner) {
        return carList.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::getName).toList();
    }

    public boolean isEmpty() {
        return carList.isEmpty();
    }
}
