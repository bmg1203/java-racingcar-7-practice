package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domian.car.Car;

public class Winners {

    private final List<Car> winners = new ArrayList<>();

    public List<Car> findWinners() {
        return new ArrayList<>(winners);
    }

    private Winners() {
    }

    public static Winners createWinners() {
        return new Winners();
    }

    public void addWinners(Car car) {
        winners.add(car);
    }


}
