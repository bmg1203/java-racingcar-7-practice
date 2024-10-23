package racingcar.model;

public class Car {
    private final MoveStrategy moveStrategy;
    private final String name;
    private int position;

    public Car(MoveStrategy moveStrategy, String name) {
        this.moveStrategy = moveStrategy;
        this.name = name;
    }

    public void move() {
        int moveCount = moveStrategy.getPossibleMoveCount();
        position += moveCount;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
