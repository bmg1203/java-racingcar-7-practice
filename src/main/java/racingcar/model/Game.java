package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public final class Game {
    private final List<Car> carList = new ArrayList<>();
    private final int totalRound;

    public Game(int totalRound) {
        this.totalRound = totalRound;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void playRound() {
        for (Car car : carList) {
            car.attemptMove();
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getTotalRound() {
        return totalRound;
    }
}
