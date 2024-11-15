package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private final Cars cars;
    private final int tryCount;

    public RacingGame(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public Cars getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void execute(String name, int randomNumber) {
        Car car = cars.getCars().get(name);
        car.plusDistance(randomNumber);
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
