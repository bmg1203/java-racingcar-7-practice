package racingcar.domain;

public class Car {

    private static final int LOWEST_MOVEMENT = 4;

    String name;
    String state;

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public Car(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public Car act(int randomNum) {
        if (randomNum >= LOWEST_MOVEMENT) {
            move();
        }
        return this;
    }

    private void move() {
        this.state = String.join("", this.state, "-");
    }

}
