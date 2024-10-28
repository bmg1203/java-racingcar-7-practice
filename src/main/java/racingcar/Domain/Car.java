package racingcar.Domain;

public class Car {
    private final String name;
    private final Position position;

    public Car(String name) {
        this.name = CarName.from(name).toString();
        this.position = new Position();
    }

    public int getPosition() {
        return position.getValue();
    }

    public void move() {
        if (MovingStrategy.canMove()) {
            position.moveForward();
        }
    }


    public String getName() {
        return name;
    }
}
