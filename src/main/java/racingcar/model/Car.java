package racingcar.model;

public class Car {

    private final String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        distance++;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
