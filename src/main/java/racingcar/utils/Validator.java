package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static final Integer NAME_LENGTH_LIMIT = 5;
    public static final String NAME_LENGTH_OVER_LIMIT_MESSAGE = "이름은 5자 이하이어야 합니다.";
    public static final String INPUT_NAME_MESSAGE = "이름을 입력해야 합니다.";
    public static final String NAME_ALREADY_EXISTS_MESSAGE = "이름이 중복합니다.";
    public static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자이여야 합니다.";
    public static final String MIN_ATTEMPT_COUNT_MESSAGE = "1번 이상이어야 합니다.";


    private Validator() {
    }

    public static void validateNameLengthLimit(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_LENGTH_OVER_LIMIT_MESSAGE);
        }
    }

    public static void validateNameIsEmpty(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException(INPUT_NAME_MESSAGE);
        }
    }

    public static void validateNameIsDuplicate(List<String> names) {
        Set<String> carNames = new HashSet<>();

        for (String name : names) {
            if (!carNames.add(name)) {
                throw new IllegalArgumentException(NAME_ALREADY_EXISTS_MESSAGE);
            }
        }
    }

    private static int validateIsNumber(String attemptCountInput) {
        try {
            return Integer.parseInt(attemptCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    public static int validateIsPositiveNumber(String attemptCountInput) {
        int attemptCount = validateIsNumber(attemptCountInput);
        if (attemptCount <= 0) {
            throw new IllegalArgumentException(MIN_ATTEMPT_COUNT_MESSAGE);
        }
        return attemptCount;
    }

}
