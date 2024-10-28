package racingcar.domain.Car;

import racingcar.domain.randomnumber.RandomNumberGenerator;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MIN_RANDOM_VALUE = 0;

    private final Name name;
    private int position;

    public Car(Name carName) {
        this.name = carName;
        position = INITIAL_POSITION;
    }

    public void moveForward(RandomNumberGenerator<Integer> randomNumberGenerator) {
        int randomValue = randomNumberGenerator.pickNumber();

        if (randomValue >= MOVE_THRESHOLD) {
            incrementPosition();
        }
    }

    public void incrementPosition() {
        position += 1;
    }


    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
