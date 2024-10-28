package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final AttemptCount attemptCount;
    private final List<List<CarSnapshot>> roundResults = new ArrayList<>();

    public RacingGame(Cars cars, AttemptCount attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void play() {
        for (int i = 0; i < attemptCount.getAttemptCount(); i++) {
            cars.moveCars();
            saveRoundResult();
        }
    }

    private void saveRoundResult() {
        roundResults.add(getCurrentRoundResult());
    }

    private List<CarSnapshot> getCurrentRoundResult() {
        return cars.getAllCars().stream()
                .map(CarSnapshot::new)
                .toList();
    }

    public List<List<CarSnapshot>> getRoundResults() {
        return roundResults;
    }

    public List<String> getWinnerNames() {
        final Integer maxPosition = getMaxPosition(roundResults);

        return roundResults.getLast().stream()
                .filter(carSnapshot -> carSnapshot.position() == maxPosition)
                .map(CarSnapshot::carName)
                .toList();
    }

    private static Integer getMaxPosition(List<List<CarSnapshot>> roundResults) {
        return roundResults.getLast().stream()
                .map(CarSnapshot::position)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("라운드 최종 결과가 비어있습니다."));
    }
}
