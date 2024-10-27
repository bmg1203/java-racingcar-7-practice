package racingcar.error;

public enum ErrorMessage {
    EMPTY_CAR_STRING("빈 자동차 문자열입니다 자동차를 입력해주세요"),
    NO_DELIMITER_CAR_STRING("자동차 문자열에 , 구분자가 없습니다."),
    NO_NUMBER_COUNT_STRING("숫자가 정수가 아닙니다."),
    CARNAME_GREATER_THAN_EQUAL_FIVE("자동차 이름길이가 5이상입니다"),
    CARNAME_NOT_STRING("자동차이름이 문자가 아닙니다.");


    private final String message;

    ErrorMessage(final String errormessage) {
        this.message = errormessage;
    }

    public String getMessage() {
        return message;
    }
}
