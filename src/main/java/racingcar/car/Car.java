package racingcar.car;

import java.util.Objects;

public final class Car {
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String ERROR_BLANK_NAME = "자동차 이름은 공백일 수 없습니다.";
    private static final String ERROR_NAME_LENGTH = "자동차 이름은 %d자 이하만 가능합니다.".formatted(NAME_LENGTH_LIMIT);
    private final String name;
    private Integer position = 0;

    private void validateBlankName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK_NAME);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    public Car(String name) {
        name = name.strip();
        validateBlankName(name);
        validateNameLength(name);
        this.name = name;
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Car) obj;
        return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}