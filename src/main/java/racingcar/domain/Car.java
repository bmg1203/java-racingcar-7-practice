package racingcar.domain;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void updateDistance(int distance) {
        this.distance += distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

}
