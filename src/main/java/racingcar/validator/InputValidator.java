package racingcar.validator;

import java.util.HashSet;
import java.util.List;

public class InputValidator {
    public static void validateMaxLength5(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("이름은 다섯 글자를 초과할 수 없습니다.");
        }
    }

    public static int parseIntWithValidation(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 값이 아닙니다 : " + input);
        }
    }

    public static void validateEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 공백입니다.");
        }
    }

    public static void validateAlphaNumeric(String str) {
        if (!str.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("숫자와 알파벳 외에 다른 값이 입력되었어요 : " + str);
        }
    }

    public static void validateForDuplicates(List<String> strings) {
        HashSet<String> uniqueStrings = new HashSet<>();
        for (String str : strings) {
            if (!uniqueStrings.add(str.trim())) {
                throw new IllegalArgumentException("중복된 이름입니다 : " + str.trim());
            }
        }
    }

}