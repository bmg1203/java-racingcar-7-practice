package racingcar.carRace;

import racingcar.carAction.CarAction;
import racingcar.domian.car.Car;

public class CarRace {
    private Car car;
    private CarAction carAction;


    private CarRace(Car car, CarAction carAction) {
        this.car = car;
        this.carAction = carAction;
    }

    public static CarRace createCarRace(Car car, CarAction carAction) {
        return new CarRace(car, carAction);
    }

    public void executeRace() {
        carAction.action(car);

    }


}
