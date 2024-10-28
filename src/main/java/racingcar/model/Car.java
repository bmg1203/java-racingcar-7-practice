package racingcar.model;

public class Car {
    private final String name;
    public int move;

    public Car(String name) {
        this.name = name;
        this.move = 0;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }

    public void move() {
        this.move++;
    }
}
