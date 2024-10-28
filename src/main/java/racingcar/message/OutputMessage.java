package racingcar.message;

public enum OutputMessage {
    CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ROUND_SIZE_INPUT_MESSAGE("시도할 횟수는 몇 회인가요?"),
    RESULT_MESSAGE("실행 결과"),
    WINNER_NOTICE_PREFIX("최종 우승자 : ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
