package racingcar.validator;

public class CarValidator {
    private static final int NAME_MAX_LENGTH = 5;

    public static void validateCarName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public static void validateAttempts(int attempts){
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
