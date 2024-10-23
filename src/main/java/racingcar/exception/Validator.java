package racingcar.exception;

import java.util.List;

public class Validator {
    public static long isNumeric(String tryNumberInput) {
        long tryNumber;
        try {
            tryNumber = Long.parseLong(tryNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMERIC);
        }

        return tryNumber;
    }

    public static String isNotBLANK(String carNameInput) {
        if (carNameInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.IS_BLANK);
        }
        return carNameInput;
    }

    public static void overFiveChars(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.OVER_FIVE_WORD);
        }
    }

    public static void isDuplicated(List<String> carNameList) {
        if (carNameList.size() != carNameList.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.IS_DUPLICATED);
        }
    }
}
