package racingcar.race;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final RaceMoveStrategy raceMoveStrategy;

    public Race(List<Car> cars, RaceMoveStrategy raceMoveStrategy) {
        this.cars = cars;
        this.raceMoveStrategy = raceMoveStrategy;
    }

    public void start(int gameCount) {
        while (gameCount-- > 0) {
            process();
            printProgress();
        }
        complete();
    }

    private void process() {
        for (Car car : cars) {
            if (raceMoveStrategy.canMove()) {
                car.move();
            }
        }
    }

    private void complete() {
        int winnerPosition = getWinnerPosition(cars);

        List<Car> winnerCars = new ArrayList<>();

        for (Car car : cars) {
            if (winnerPosition == car.getPosition()) {
                winnerCars.add(car);
            }
        }

        String winners = carsToString(winnerCars, ", ");
        System.out.println("최종 우승자 : " + winners);
    }

    private String carsToString(List<Car> cars, String delimiter) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(delimiter));
    }

    private int getWinnerPosition(List<Car> cars) {
        int winnerPosition = 0;
        for (Car car : cars) {
            winnerPosition = Math.max(winnerPosition, car.getPosition());
        }
        return winnerPosition;
    }

    private void printProgress() {
        for (Car car : cars) {
            String positionBar = getBar('-', car.getPosition());
            System.out.println(car.getName() + " : " + positionBar);
        }
        System.out.println();
    }

    private String getBar(char pattern, int count) {
        StringBuilder bar = new StringBuilder();
        bar.repeat(pattern, count);
        return bar.toString();
    }
}
