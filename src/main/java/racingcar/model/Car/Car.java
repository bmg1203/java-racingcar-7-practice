package racingcar.model.Car;

import java.util.Objects;

public class Car {
    private static final int MAX_CAR_NAME_SIZE = 5;
    private String carName;

    public Car(String carName) {
        validateCarNameLength(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}