package racingcar.domain;

public class Car {

    private final String name;
    private int moveCount;


    public Car(String name) {
        this.name = name;
    }

    public void move() {
        moveCount++;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

}
