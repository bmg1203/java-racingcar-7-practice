package racingcar.util;

import java.util.List;
import racingcar.exception.CarNameDuplicatedException;
import racingcar.exception.CarNameFormatException;
import racingcar.exception.CountFormatException;
import racingcar.exception.CountNegativeException;

public class Validator {

    private static final int CAR_NAME_MAX_LENGTH = 5;

    public static void validateCarNames(List<String> carNames) {
        validateCarNameEmpty(carNames);
        validateCarNameFormat(carNames);
        validateDuplicatedCarName(carNames);
    }

    public static void validateCount(String countInput) {
        validateCountFormat(countInput);
        validateCountPositive(countInput);
    }

    private static void validateCarNameFormat(List<String> carNames) {
        for (String carName : carNames) {
            if (carName == null || carName.isBlank() || carName.length() > CAR_NAME_MAX_LENGTH) {
                throw new CarNameFormatException(carName);
            }
        }
    }

    private static void validateCarNameEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new CarNameFormatException("null");
        }
    }

    private static void validateDuplicatedCarName(List<String> carNames) {
        long deduplicatedSize = carNames.stream().distinct().count();
        if (carNames.size() != deduplicatedSize) {
            throw new CarNameDuplicatedException();
        }
    }

    private static void validateCountFormat(String countInput) {
        try {
            Integer.parseInt(countInput);
        } catch (NumberFormatException e) {
            throw new CountFormatException();
        }
    }

    private static void validateCountPositive(String countInput) {
        if (Integer.parseInt(countInput) <= 0) {
            throw new CountNegativeException();
        }
    }
}
