package racingcar.model;

import racingcar.exception.ErrorType;

public class Car {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MOVABLE_NUMBER = 4;

    private String name;
    private int distance;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.distance = 0;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorType.NOT_ALLOWED_EMPTY_CAR_NAME.getMessage());
        }
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorType.EXCEEDED_MAXIMUM_CAR_NAME_LENGTH.getMessage());
        }
    }

    public void move(int condition) {
        if (condition >= MOVABLE_NUMBER) {
            this.distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
