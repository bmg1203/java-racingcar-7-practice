package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.util.RandomNumber;

public class Race {

    private final static int VALIDATE_NEGATIVE_NUMBER = 0;

    private final List<Car> cars;
    private final int tryCount;

    public Race(List<Car> cars, int tryCount) {
        validateTryCount(tryCount);
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int winnerPosition = getWinnerPosition(cars);
        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void playOneRound() {
        for (Car car : cars) {
            if (canMove()) {
                car.move();
            }
        }
    }

    private int getWinnerPosition(List<Car> cars) {
        Car winner = Collections.max(cars, Comparator.comparingInt(car -> car.getPosition()));
        int winnerPosition = winner.getPosition();
        return winnerPosition;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < VALIDATE_NEGATIVE_NUMBER) {
            throw new IllegalArgumentException("시도할 횟수는 0 이상이어야 합니다.");
        }
    }

    private boolean canMove() {
        int randomNumber = RandomNumber.generateRandomNumber();
        return RandomNumber.isMoreFour(randomNumber);
    }
}
