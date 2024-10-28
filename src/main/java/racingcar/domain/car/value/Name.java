package racingcar.domain.car.value;

import java.util.Objects;

public record Name(String value) {

    private static final String INVALID_NAME_FORM = "자동차 이름은 알파뱃으로만 작성해야 합니다.";
    private static final String INVALID_NAME_LENGTH = "자동차의 이름은 5자 이하로 작성하여야 합니다.";

    public Name {
        validate(value);
    }

    private void validate(String value) {
        validateLength(value);
        validateForm(value);
    }

    private void validateLength(String value) {
        if (value == null || value.length() > 5) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    private void validateForm(String value) {
        if (!value.matches("^[A-Za-z]+$")) {
            throw new IllegalArgumentException(INVALID_NAME_FORM);
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
