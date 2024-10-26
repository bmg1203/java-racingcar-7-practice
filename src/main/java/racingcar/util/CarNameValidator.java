package racingcar.util;

import racingcar.exception.view.CarNameInputErrorMessage;

public class CarNameValidator {

    public static void validateInput(String input) {
        checkInputIsEmpty(input);
        checkInputIncludeWhiteSpace(input);
        checkInputIncludeInvalidDelimiter(input);
    }

    // 빈 문자열 검사
    private static void checkInputIsEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(CarNameInputErrorMessage.CAR_NAME_IS_EMPTY.getMessage());
        }
    }

    // 공백 포함 여부 검사
    private static void checkInputIncludeWhiteSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(CarNameInputErrorMessage.CAR_NAME_CONTAINS_WHITESPACE.getMessage());
        }
    }

    // 구분자 유효성 검사
    private static void checkInputIncludeInvalidDelimiter(String input) {
        if (!input.matches("^[a-zA-Z,]+$")) {
            throw new IllegalArgumentException(CarNameInputErrorMessage.INVALID_DELIMITER.getMessage());
        }
    }

    // 자동차 이름 유효성 검사
    public static void validateCarName(String carName) {
        checkNameLength(carName);
        checkNameIsLowerCase(carName);
    }

    // 자동차 이름 길이 검사
    private static void checkNameLength(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException(CarNameInputErrorMessage.CAR_NAME_TOO_LONG.getMessage());
        }
    }

    // 소문자 여부 검사
    private static void checkNameIsLowerCase(String carName) {
        if (!carName.matches("^[a-z]+$")) {
            throw new IllegalArgumentException(CarNameInputErrorMessage.CAR_NAME_NOT_LOWERCASE.getMessage());
        }
    }
}
