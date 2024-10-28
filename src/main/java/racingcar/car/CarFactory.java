package racingcar.car;

public abstract class CarFactory {
    public final Car createOperation(String carName) {
        Car car = createCar();
        car.setCarName(carName);
        return car;
    }

    abstract protected Car createCar();
}
