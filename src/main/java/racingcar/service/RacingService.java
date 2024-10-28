package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingService {
    private final List<String> carNames;
    private final Map<String, Integer> carPositions = new HashMap<>();

    public RacingService(List<String> carNames) {
        this.carNames = carNames;
        carNames.forEach(car -> carPositions.put(car, 0));
    }

    private int getRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public Map<String, Integer> moveCars() {
        carPositions.forEach((car, position) -> {
            if (getRandomValue() > 3) {
                carPositions.put(car, position + 1);
            }
        });
        return carPositions;
    }

    public List<String> findWinner() {
        int maxPosition = carPositions.values().stream()
                .max(Integer::compareTo)
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (String car : carNames) {
            if (carPositions.get(car) == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
