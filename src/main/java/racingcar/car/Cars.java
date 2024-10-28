package racingcar.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import racingcar.provider.NumberProvider;

public class Cars {
    private static final int MOVING_DISTANCE_EACH_TRIAL = 1;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {

        validateDuplicatedNames(cars);

        return new Cars(cars);
    }

    public static Cars of(String... carNames) {
        List<Car> carList = new ArrayList<>();

        validateDuplicatedNames(carNames);

        for (String name : carNames) {
            carList.add(Car.from(name));
        }

        return Cars.from(carList);
    }

    public void tryMoveForward(NumberProvider provider) {
        for (Car car : cars) {
            int value = provider.getNumber();
            car.tryMoveForward(value, MOVING_DISTANCE_EACH_TRIAL);
        }
    }

    public String changeCurrentTotalPositionalStatusToVisual(String positionalCarStatusSymbol) {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());

        for (Car car : cars) {
            String currentPositionalVisualStatus = car.changeCurrentPositionalStatusToVisual(
                    positionalCarStatusSymbol);

            stringJoiner.add(currentPositionalVisualStatus);
        }

        return stringJoiner.toString();

    }

    public List<Car> findWinnerList() {
        Car winnerCar = Collections.max(cars);

        return cars.stream()
                .filter(car -> car.isSamePosition(winnerCar))
                .toList();
    }


    private static void validateDuplicatedNames(List<Car> cars) {
        boolean isDuplicated = cars.stream()
                .distinct()
                .count() != cars.size();

        if (isDuplicated) {
            throw new IllegalArgumentException("자동차 이름은 서로 중복될 수 없습니다.");
        }

    }

    private static void validateDuplicatedNames(String[] carNames) {
        boolean isDuplicated = Arrays.stream(carNames)
                .distinct()
                .count() != carNames.length;

        if (isDuplicated) {
            throw new IllegalArgumentException("자동차 이름은 서로 중복될 수 없습니다.");
        }
    }
}
