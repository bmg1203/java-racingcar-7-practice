package racingcar.util;

public class InputValidator {
    public static void validCarName(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    public static void validRound(String input) {
        try {
            if (Integer.parseInt(input) > 0) return;
            throw new IllegalArgumentException("시도할 횟수는 양수여야 합니다.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 정수여야 합니다.");
        }
    }
}
