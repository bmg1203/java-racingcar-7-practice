package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public List<String> validateCarNames(String userInput) {
        List<String> carNames = List.of(userInput.split(Constant.INPUT_DELIMITER));

        validateNameLength(carNames);
        validateNameEmpty(carNames);
        validateNameDuplicate(carNames);

        return carNames;
    }

    public int validateAttemptCount(String userInput) {
        validateNumber(userInput);

        int attemptCount = Integer.parseInt(userInput);
        validatePositiveNumber(attemptCount);

        return attemptCount;
    }

    private void validateNameDuplicate(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);

        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException(Constant.CAR_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > Constant.CAR_NAME_MAX_LENGTH_VALUE) {
                throw new IllegalArgumentException(Constant.CAR_NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    private void validateNameEmpty(List<String> carNames) {
        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException(Constant.CAR_NAME_EMPTY_ERROR_MESSAGE);
            }
        }
    }

    private void validateNumber(String userInput) {
        if (!userInput.matches(Constant.INTEGER_REGEX)) {
            throw new IllegalArgumentException(Constant.ATTEMPT_COUNT_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validatePositiveNumber(int attemptCount) {
        if (attemptCount < Constant.ATTEMPT_COUNT_MIN_VALUE) {
            throw new IllegalArgumentException(Constant.ATTEMPT_COUNT_NUMBER_ERROR_MESSAGE);
        }
    }
}
