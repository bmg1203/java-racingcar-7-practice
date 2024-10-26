package racingcar.model.position;

import static java.util.Objects.requireNonNull;
import static racingcar.common.message.ErrorMessage.SHOULD_NOT_BE_NULL;

import java.util.Objects;

public class Position {

    public static Position ON_START_LINE = initiate();

    private final String value;

    // Constructor
    private Position(final String value) {
        this.value = value;
    }

    private static Position initiate() {
        return new Position("");
    }

    public static Position from(String source) {
        requireNonNull(source, SHOULD_NOT_BE_NULL);
        return new Position(source);
    }

    // Method
    public Position add(final Distance distance) {
        Distance destination = currentDistance().add(distance);
        return PositionBuilder.from(destination);
    }

    private Distance currentDistance() {
        return Distance.from(value.length());
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position oPosition = (Position) obj;
        return Objects.equals(this.value, oPosition.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
