package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Constants.WINNER_NOTICE;
import static racingcar.Utils.println;

public class FinishRace {
    protected List<String> determineWinner(final List<Car> cars) {
        int maxMovedAmount = 0;
        List<Car> candidateCars = new ArrayList<>();

        // 참가 자동차 배열을 순회하면서 movedAmount가 가장 큰 자동차 저장
        for (Car car : cars) {
            if (car.movedAmount > maxMovedAmount) {
                maxMovedAmount = car.movedAmount;
                candidateCars.clear();
            } else if (car.movedAmount < maxMovedAmount) {
                continue;
            }
            candidateCars.add(car);
        }

        return getWinnerNames(candidateCars);
    }

    private List<String> getWinnerNames(final List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();

        winners.forEach(car -> winnerNames.add(car.getName()));

        return winnerNames;
    }

    protected void printGameWinners(final List<String> winners) {
        println(WINNER_NOTICE + String.join(", ", winners));
    }
}
