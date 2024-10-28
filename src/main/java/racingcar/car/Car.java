package racingcar.car;

public class Car {
    private static final int MOVE_TRIGGER = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_TRIGGER) {
            this.position++;
        }
    }
}
