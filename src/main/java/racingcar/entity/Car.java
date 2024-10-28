package racingcar.entity;

import racingcar.Config;
import racingcar.exception.CarNameValidationError;
import racingcar.exception.ExceptionUtils;

public class Car {
    final private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        validate(name);

    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= Config.MOVE_MINIMUM_VALUE.getValue()) {
            this.position++;
        }
    }

    private void validate(String name) {
        if (name == null) {
            ExceptionUtils.throwIllegalArgException(CarNameValidationError.NAME_NULL);
        } else if (name.isEmpty()) {
            ExceptionUtils.throwIllegalArgException(CarNameValidationError.NAME_EMPTY);
        } else if (5 < name.length()) {
            ExceptionUtils.throwIllegalArgException(CarNameValidationError.NAME_TOO_LONG);
        } else if (name.contains(" ")) {
            ExceptionUtils.throwIllegalArgException(CarNameValidationError.NAME_CONTAINS_SPACE);
        }
    }

}