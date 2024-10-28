package racingcar.domain.movement;

import racingcar.constant.GameConstants;
import racingcar.domain.car.Distance;

public class MovementPolicy {
    private static final Distance FORWARD_STEP = Distance.of(GameConstants.FORWARD_STEP);
    private final MovementStrategy strategy;

    public MovementPolicy(MovementStrategy strategy) {
        this.strategy = strategy;
    }

    public Distance move(Distance current) {
        if (strategy.shouldMove()) {
            return current.add(FORWARD_STEP);
        }
        return current;
    }

}
