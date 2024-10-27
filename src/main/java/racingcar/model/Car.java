package racingcar.model;

public class Car {
    private final String name;
    private int forwardCount;

    public Car(String name) {
        this.name = name;
        forwardCount = 0;
    }

    public String getName() {
        return name;
    }

    public void moveOneStep() {
        forwardCount++;
    }

    public int getForwardCount() {
        return forwardCount;
    }

}
