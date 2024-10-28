package racingcar.validate;

import racingcar.validate.enums.ValidateMessages;

public class InputNumberValidation {
    public static void validateInputNumber(String inputNumber) {
        validateNumberIfNullOrEmpty(inputNumber);
        validateNumberIfNegative(inputNumber);
        validateIfInputCanCovertToInt(inputNumber);
        validateNumberIfContainsNewLine(inputNumber);
        validateNumberifWhiteSpaceExist(inputNumber);
        validateIfNumberStartsWithZero(inputNumber);
    }

    public static void validateNumberIfNullOrEmpty(String inputNumber) {
        if (inputNumber == null || inputNumber.isEmpty()) {
            throw new IllegalArgumentException(ValidateMessages.NUMBER_CANNOT_BE_NULL_OR_EMPTY.getValidateMessage());
        }
    }

    public static void validateNumberIfNegative(String inputNumber) {
        if (Integer.parseInt(inputNumber) < 0) {
            throw new IllegalArgumentException(ValidateMessages.NUMBER_CANNOT_BE_NEGATIVE.getValidateMessage());
        }
    }

    public static void validateIfInputCanCovertToInt(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidateMessages.NUMBER_SHOULD_BE_INTEGER.getValidateMessage());
        }
    }

    public static void validateNumberIfContainsNewLine(String inputNumber) {
        if (inputNumber.contains("\n")) {
            throw new IllegalArgumentException(
                    ValidateMessages.NUMBER_SHOULD_NOT_CONTAIN_NEW_LINE.getValidateMessage());
        }
    }

    public static void validateNumberifWhiteSpaceExist(String inputNumber) {
        if (inputNumber.contains(" ")) {
            throw new IllegalArgumentException(ValidateMessages.NUMBER_SHOULD_NOT_CONTAIN_EMPTY.getValidateMessage());
        }
    }

    public static void validateIfNumberStartsWithZero(String inputNumber) {
        if (inputNumber.length() > 1 && inputNumber.startsWith("0")) {
            throw new IllegalArgumentException(ValidateMessages.NUMBER_CANNOT_START_WITH_ZERO.getValidateMessage());
        }
    }
}
