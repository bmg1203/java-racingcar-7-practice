package racingcar.message.exception;

public class CarNameSplitExceptionMessage {
    public static final String CAR_NAME_INCLUDE_BLANK = "자동차 이름은 공백 혹은 빈 문자열은 허용되지 않습니다";
    public static final String CAR_NAMES_LAST_COMMA = "자동차 이름 문자열은 콤마로 끝날 수 없습니다.";
    public static final String CAR_NAME_COUNT_IS_ONE = "자동차는 한 개만 등록될 수 없습니다.";
    public static final String CAR_NAME_DUPLICATE = "자동차 이름은 중복될 수 없습니다.";
    public static final String CAR_NAME_LENGTH_OVER = "자동차 이름은 5글자 이하입니다.";
    public static final String CAR_NAME_INCLUDE_SPECIAL_CHARACTERS = "자동차 이름은 한글, 영어, 숫자로만 구성될 수 있습니다";
}
