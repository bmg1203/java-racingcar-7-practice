package racingcar.model;

import static racingcar.constants.Constants.MAX_NAME_LENGTH;

import java.util.Objects;
import racingcar.constants.ErrorMessages;

public class CarName {
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private void validateName(String name) {
        validateBlank(name);
        validateLength(name);
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_BLANK.getMessage());
        }
    }

    private void validateLength(String name) {
        if (!isProperLength(name)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_RANGE.getMessage());
        }
    }

    private boolean isProperLength(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }
}
