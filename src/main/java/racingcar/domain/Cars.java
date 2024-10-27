package racingcar.domain;

import racingcar.view.StatusView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;

    private Cars(String[] names) {
        cars = Arrays.stream(names)
                .map(Car::new)
                .toList();
    }

    public static Cars from(String[] names) {
        return new Cars(names);
    }

    public void racing(int moveNum) {
        StatusView.printExecutionResult();
        IntStream.range(0, moveNum)
                .forEach(i -> {
                    cars.forEach(Car::moveOrStop);
                    StatusView.printStatus(cars);
                });
    }

    // 테스트 전용 메서드
    public Car getCar(int carNumber) {
        return cars.get(carNumber);
    }

    public Winners determineWinner() {
        int maxAdvanceNum = getMaxAdvanceNum();
        return createWinners(maxAdvanceNum);
    }

    public int getMaxAdvanceNum() {
        return cars.stream()
                .mapToInt(Car::getAdvanceNum)
                .max()
                .orElse(0);
    }

    private Winners createWinners(int maxAdvanceNum) {
        List<Car> winners = cars.stream()
                .filter(car -> car.getAdvanceNum() == maxAdvanceNum)
                .toList();
        return new Winners(winners);
    }
}
