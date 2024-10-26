package racingcar.validator;

import java.util.List;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void isValidCarNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 입력해 주세요.");
            }
        }
    }

    public static void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("횟수는 1 이상의 정수로 입력해 주세요.");
        }
    }
}
