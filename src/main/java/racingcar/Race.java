package racingcar;

import java.util.List;

public class Race {
    private List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public List<CarStatus> getRoundResult() {
        return cars.stream().map(car ->
                        new CarStatus(car.getName(), car.getCurrentPosition()))
                .toList();
    }


}
