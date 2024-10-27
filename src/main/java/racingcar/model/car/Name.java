package racingcar.model.car;

import java.util.Objects;
import java.util.regex.Pattern;
import racingcar.common.ErrorMessage;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final Pattern VALID_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
    private final String name;

    Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        validateBlankName(name);
        validateNameLength(name);
        validateNameCharacters(name);
    }

    private void validateBlankName(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.getMessage());
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
        }
    }

    private void validateNameCharacters(final String name) {
        if (!VALID_NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_INVALID_CHARACTER.getMessage());
        }
    }

    public String getCarName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
