package racingcar.model;

public class Car {
    private String name;
    private int movedDistance;
    public Car(String name) {
        this.name = name;
        movedDistance = 0;
    }

    public void move() {
        movedDistance += 1;
    }
}
