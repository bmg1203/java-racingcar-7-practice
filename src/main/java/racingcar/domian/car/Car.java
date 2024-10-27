package racingcar.domian.car;

public class Car implements Comparable<Car> {
    private final Name carName;
    private Position position = Position.createPosition();

    private Car(String carName) {
        this.carName = Name.createName(carName);
    }

    public static Car createCar(String carName) {
        return new Car(carName);
    }

    public void forward() {
        position.forwardPosition();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getCarName() {
        return carName.getName();
    }


    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.getPosition(), this.getPosition());
    }

    @Override
    public String toString() {
        return position.getPosition() + " ";

    }
}
