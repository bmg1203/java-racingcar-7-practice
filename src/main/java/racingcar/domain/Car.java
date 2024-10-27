package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MOVE_STANDARD = 4;
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String LINE_CHANGE = "\n";

    private final Name name;
    private Position position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, int position) {
        this(new Name(name), position);
    }

    public Car(final Name name, int position) {
        this(name, new Position(position));
    }

    public Car(final Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car decideMove(int random) {
        if (random >= MOVE_STANDARD) {
            position = position.move();
            return new Car(name, position);
        }
        return this;
    }

    public int getLargerMove(int move) {
        return position.getLargerPosition(move);
    }

    public boolean isSameMaxMove(int maxMove) {
        return position.isSamePosition(maxMove);
    }

    public String getName() {
        return name.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Car car)) {
            return false;
        }
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.toString()
                + NAME_POSITION_SEPARATOR
                + position.signCount()
                + LINE_CHANGE;
    }

}
