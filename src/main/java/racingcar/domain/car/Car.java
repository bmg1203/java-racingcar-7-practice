package racingcar.domain.car;

public class Car {

    private final String name;
    private int position;
    private final MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.position = 0;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (checkMovable()) {
            position++;
        }
    }

    private boolean checkMovable() {
        return moveStrategy.isMovable();
    }

}
