package racingcar.exceptions;

public enum RacingCarExceptionMessage {
    NO_TRY_NUM("시도 횟수가 입력되지 않았습니다."),
    TRY_NUM_CANNOT_BE_ZERO("시도 횟수는 0이 될 수 없습니다."),
    CAR_NAME_CANNOT_EXCEED_FIVE("차 이름은 5자를 초과할 수 없습니다."),
    CAR_NAME_LENGTH_CANNOT_BE_ZERO("자동차 이름의 길이는 0이 될 수 없습니다."),
    CAR_NAME_CANNOT_BE_NULL("자동차 이름은 null이 될 수 없습니다."),
    ;

    private final String text;
    RacingCarExceptionMessage(String text) {
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}
