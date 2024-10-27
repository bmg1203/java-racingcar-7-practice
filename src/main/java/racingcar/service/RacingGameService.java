package racingcar.service;

import racingcar.util.RandomGenerator;
import racingcar.vo.Car;

import java.util.Set;

public class RacingGameService {

    private static final int MOVING_FORWARD = 4;
    private final RandomGenerator randomGenerator;

    public RacingGameService(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public void moveCars(Set<Car> cars) {
        cars.stream()
                .filter(car -> shouldMoveForward())
                .forEach(Car::forward);
    }

    private boolean shouldMoveForward() {
        return randomGenerator.generateNumber() >= MOVING_FORWARD;
    }

}
