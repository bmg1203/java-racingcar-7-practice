package racingcar.entity;

public class Car {

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

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}