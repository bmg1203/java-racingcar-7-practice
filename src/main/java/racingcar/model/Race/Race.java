package racingcar.model.Race;

import java.util.List;
import racingcar.model.Cars.Cars;
import racingcar.model.Winners.Winners;

public class Race {

    private final Cars cars;
    private final TryCount tryCount;

    public Race(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void round() {
        for (Car car : cars.getCars()) {
            car.move();
        }
    }

    public int getTryCount() {
        return tryCount.getCount();
    }

    public List<Car> getPlayers() {
        return cars.getCars();
    }

    public Winners createWinner() {
        return Winners.from(cars);
    }
}
