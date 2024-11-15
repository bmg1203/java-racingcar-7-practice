package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    public List<String> getWinners(Cars cars) {
        int maxDistance = getMaxDistance(cars);
        List<String> winners = new ArrayList<>();

        for (Car car : cars.getCars().values()) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int getMaxDistance(Cars cars) {
        int max = Integer.MIN_VALUE;

        for (Car car : cars.getCars().values()) {
            max = Math.max(max, car.getDistance());
        }
        return max;
    }
}
