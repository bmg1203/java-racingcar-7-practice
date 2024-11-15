package racingcar.domain;

import java.util.Map;

public class Cars {

    private final Map<String, Car> cars;

    public Cars(Map<String, Car> cars) {
        this.cars = cars;
    }

    public Map<String, Car> getCars() {
        return cars;
    }
}
