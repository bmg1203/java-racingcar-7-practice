package racingcar.validator;

import java.util.List;

public class BasicRacingCarValidator implements RacingCarValidator {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int MOVE_COUNT_MIN = 1;

    @Override
    public void validateCarNamesAndMoveCount(List<String> carNames, int moveCount) {

    }

    private void validateCarNameLengthLessThanMax(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNameLengthMoreThanMin(String carName) {
        if (carName.length() < CAR_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMoveCountMoreThanMin(int moveCount) {
        if (moveCount < MOVE_COUNT_MIN) {
            throw new IllegalArgumentException();
        }
    }
}
