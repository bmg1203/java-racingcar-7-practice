package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<String> carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
