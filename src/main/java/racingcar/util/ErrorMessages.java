package racingcar.util;

public class ErrorMessages {

    public static final String INVALID_CAR_NAME = "[ERROR] 자동차 이름은 공백이 아니면서 5자 이내여야 합니다.";
    public static final String INVALID_ROUND_COUNT = "[ERROR] 시도 횟수는 양의 정수여야 합니다.";
    public static final String NON_NUMERIC_ROUND_COUNT = "[ERROR] 시도 횟수는 숫자로 입력해야 합니다.";

    // 생성자를 private으로 추가해 인스턴스 생성을 방지한다.
    private ErrorMessages() {
    }
}
