package racingcar.model;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public String getCurrentPositionString(){
        return "-".repeat(position);
    }

    public void moveForward() {
        this.position += 1;
    }
}
