package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable())
            position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
