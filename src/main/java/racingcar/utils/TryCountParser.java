package racingcar.utils;

import static racingcar.validator.TryCountValidator.validateTryCount;

public class TryCountParser {
    public static int parse(String input) {
        validateTryCount(input);

        return Integer.parseInt(input);
    }
}
