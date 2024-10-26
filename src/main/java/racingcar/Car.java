package racingcar;

public class Car {
    private String name;
    private int moveCount;

    Car(String _name) {
        name = _name;
        moveCount = 0;
    }

    public void increaseMoveCount() { moveCount++; }

    public int getMoveCount() { return moveCount; }
}