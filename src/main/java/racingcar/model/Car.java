package racingcar.model;

import racingcar.strategy.Strategy;

/**
 * 자동차를 구현한 클래스, 움직이는 것은 전략 클래스에 위임한다.
 */
public class Car {

    private final String name;

    private final Strategy strategy;

    private int progress;

    public Car(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
        this.progress = 0;
    }
    public void moveOrNot() {
        progress += strategy.getDistanceMove();
    }

    public int getProgress() {
        return progress;
    }

    public String getName() {
        return name;
    }

}
