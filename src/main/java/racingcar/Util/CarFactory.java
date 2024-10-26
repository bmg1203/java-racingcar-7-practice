package racingcar.Util;

import java.util.List;
import racingcar.Model.Car;

public class CarFactory {
    public List<Car> makeCarList(List<String> names) {
        return names.stream().map(this::makeCar).toList();
    }

    private Car makeCar(String name) {
        return new Car(name);
    }
}
