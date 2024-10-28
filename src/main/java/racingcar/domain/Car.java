package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MINIMUM_MOVABLE_NUMBER = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void attemptMoveForward() {
        if (isMovable()) {
            position++;
        }
    }

    private static boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= MINIMUM_MOVABLE_NUMBER;
    }
}
