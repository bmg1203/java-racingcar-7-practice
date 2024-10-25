package racingcar.util.validator;

public class CarNamesValidator {

    private static final int MIN_CAR_COUNT = 1;
    private static final int MAX_CAR_COUNT = 100;
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_SEPARATOR = ",";
    private static final String INVALID_SEPARATOR_POSITION_MESSAGE = "구분자는 입력의 첫번째 또는 마지막에 올 수 없습니다";
    private static final String INVALID_CONSECUTIVE_SEPARATOR_MESSAGE = "연속된 구분자를 사용할 수 없습니다.";
    private static final String INVALID_CAR_COUNT_MESSAGE = "자동차는 최소 1대 이상 100대 이하로만 가능합니다.";
    private static final String INVALID_CAR_NAME_MESSAGE = "자동차 이름은 최소 1자 이상 5자 이하만 가능합니다.";

    public static void validate(String carNames) {
        validateSeparatorPosition(carNames);
        String[] splitCarNames = carNames.split(CAR_NAME_SEPARATOR);
        validateNumberOfCars(splitCarNames);
        validateCarNames(splitCarNames);
    }

    private static void validateSeparatorPosition(String carNames) {
        if (!isValidSeparatorPosition(carNames)) {
            throw new IllegalArgumentException(INVALID_SEPARATOR_POSITION_MESSAGE);
        }

        if (!isValidConsecutiveSeparator(carNames)) {
            throw new IllegalArgumentException(INVALID_CONSECUTIVE_SEPARATOR_MESSAGE);
        }
    }

    private static void validateNumberOfCars(String[] splitCarNames) {
        if (!isValidateNumberOfCars(splitCarNames)) {
            throw new IllegalArgumentException(INVALID_CAR_COUNT_MESSAGE);
        }
    }

    private static void validateCarNames(String[] splitCarNames) {
        for (String splitCarName : splitCarNames) {
            if (!isValidCarNameLength(splitCarName)) {
                throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
            }
        }
    }

    private static boolean isValidSeparatorPosition(String carNames) {
        return !(carNames.startsWith(CAR_NAME_SEPARATOR) || carNames.endsWith(CAR_NAME_SEPARATOR));
    }

    private static boolean isValidConsecutiveSeparator(String carNames) {
        return !carNames.contains(CAR_NAME_SEPARATOR + CAR_NAME_SEPARATOR);
    }

    private static boolean isValidateNumberOfCars(String[] carNames) {
        return carNames.length >= MIN_CAR_COUNT && carNames.length <= MAX_CAR_COUNT;
    }

    private static boolean isValidCarNameLength(String carName) {
        return carName.length() >= MIN_CAR_NAME_LENGTH && carName.length() <= MAX_CAR_NAME_LENGTH;
    }
}
