package racingcar.service;

import static java.util.Comparator.*;
import static racingcar.util.constant.MoveCarNumberConstant.CAR_IS_NOT_STARTED_YET;
import static racingcar.util.constant.MoveCarNumberConstant.CAR_MOVE_CONDITION;
import static racingcar.util.constant.MoveCarNumberConstant.RANDOM_NUMBER_END_WITH;
import static racingcar.util.constant.MoveCarNumberConstant.RANDOM_NUMBER_START_WITH;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.TheCarDoesntStartException;
import racingcar.model.Car;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {

    public boolean isMoving() {
        final int carCondition = randomNumber();
        return carCondition >= CAR_MOVE_CONDITION.getValue();
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START_WITH.getValue(), RANDOM_NUMBER_END_WITH.getValue());
    }

    public List<Car> winners(List<Car> cars) {
        List<Car> raceResult = new ArrayList<>(cars);
        sortResultsDescendingOrder(raceResult);

        final int winningScore = raceResult.getFirst().getDistance();
        isValidRaceResult(winningScore);

        return raceResult.stream().filter(c -> c.getDistance() == winningScore).toList();
    }

    private void sortResultsDescendingOrder(List<Car> results) {
        results.sort(comparingInt(Car::getDistance).reversed());
    }

    private boolean isValidRaceResult(final int winningScore) {
        if(winningScore == CAR_IS_NOT_STARTED_YET.getValue()) {
            throw new TheCarDoesntStartException();
        }
        return true;
    }
}
