package racingcar.service;

import static java.util.Comparator.*;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.TheCarDoesntStartException;
import racingcar.model.Car;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
    // TODO : 상수화 리팩토링
    public boolean isMoving() {
        int carCondition = randomNumber();
        return carCondition >= 4;
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<Car> raceResult(List<Car> cars) {
        List<Car> winners = new ArrayList<>(cars);
        winners.sort(comparingInt(Car::getDistance).reversed());

        int winningScore = winners.getFirst().getDistance();
        isRaceStarted(winningScore);

        return winners.stream().filter(c -> c.getDistance() == winningScore).toList();
    }

    private boolean isRaceStarted(Integer winningScore) {
        if(winningScore == 0) {
            throw new TheCarDoesntStartException();
        }
        return true;
    }
}
