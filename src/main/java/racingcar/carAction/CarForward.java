package racingcar.carAction;

import racingcar.domian.car.Car;

public class CarForward implements CarAction {

    public void action(Car car) {
        car.forward();
    }
}
