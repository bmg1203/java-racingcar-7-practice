package racingcar.message;

public class ErrorMessages {

    // Car names related error messages
    public static final String UNPROVIDED_NAMES = "[ERROR] 입력된 이름이 없습니다. 이름을 1개 이상 입력해주세요.";
    public static final String DUPLICATED_NAMES = "[ERROR] 중복된 이름이 있습니다. 각 이름이 고유하도록 입력해주세요.";

    // Car name related errors messages
    public static final String CLEAR_NAME = "[ERROR] 이름은 비워둘 수 없습니다. 이름을 입력해주세요.";
    public static final String LONG_NAME = "[ERROR] 이름이 너무 깁니다. 5자 이하로 입력해주세요.";

    // Try count related errors messages
    public static final String TRY_COUNT_NOT_VALID_NUMBER = "[ERROR] 시도 횟수가 유효하지 않습니다. 시도 횟수는 0 이상 1000이하로 입력해주세요.";
}
