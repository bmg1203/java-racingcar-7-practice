package racingcar.model;

import java.util.Objects;

public class Distance {
    private int distance;


    public Distance() {
        this.distance = 0;
    }

    public void stepForward() {
        distance += 1;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(distance);
    }

}
