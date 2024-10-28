package racingcar.domain;

import java.util.Objects;

public class CarPosition {

    public static final int START_POSITION = 0;
    private int position;

    public CarPosition() {
        this.position = START_POSITION;
    }

    public void increase() {
        position++;
    }

    public boolean isGreaterThan(CarPosition other) {
        return this.position > other.position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
