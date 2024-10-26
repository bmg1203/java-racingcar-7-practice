package racingcar.domain;

public class Race {

    private final Cars cars;
    private final TrialCounts trialCounts;
    private int currentCounts;

    public Race(Cars cars, TrialCounts trialCounts) {
        this.cars = cars;
        this.trialCounts = trialCounts;
        this.currentCounts = 0;
    }

    private void moveCars() {
        for (Car car : cars.getCars()) {
            car.move(RandomNumber.getRandomNumber());
        }
    }

    private void increaseCurrentCounts() {
        currentCounts++;
    }

    public void startRace() {
        moveCars();
        increaseCurrentCounts();
    }

    public boolean isRaceOngoing() {
        return currentCounts < trialCounts.getTrialCounts();
    }
}
