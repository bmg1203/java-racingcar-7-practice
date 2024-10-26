package racingcar;

import static racingcar.ErrorMessage.EMPTY_NAME;
import static racingcar.ErrorMessage.INVALID_CAR_NAME;
import static racingcar.ErrorMessage.TOO_LONG_CAR_NAME;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int MOVING_FORWARD = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String VALID_NAME_REGEX = "[a-zA-Zㄱ-ㅣ가-힣]+";

    private final String name;
    private int movedCount;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private static void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME.getMessage());
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(TOO_LONG_CAR_NAME.getMessage());
        }

        if (!name.matches(VALID_NAME_REGEX)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }
    }

    public void move() {
        int fate = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
        if (fate >= MOVING_FORWARD) {
            this.movedCount++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int countMove() {
        return this.movedCount;
    }
}
