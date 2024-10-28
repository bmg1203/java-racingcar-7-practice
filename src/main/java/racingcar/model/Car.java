package racingcar.model;

import racingcar.exception.CarException;

public class Car {
    private static final int MINIMUM_MOVE_NUMBER = 4;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int seed) {
        if (seed < MINIMUM_MOVE_NUMBER) {
            return;
        }
        position++;
    }

    public String getPositionInfo() {
        return this.name + " : " + "-".repeat(this.position);
    }

    private void validateName(String name) {
        validateNameNullOrEmpty(name);
        validateNameLength(name);
    }

    private static void validateNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(CarException.CAR_NAME_IS_OVER_FIVE.getMessage());
        }
    }

    private static void validateNameNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(CarException.CAR_NAME_IS_NULL_OR_EMPTY.getMessage());
        }
    }
}