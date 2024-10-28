package racingcar;

public enum GuideMessage {
    INPUT_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ITER("시도할 횟수는 몇 회인가요?"),
    RACE_START("\n실행 결과"),
    RACE_WINNER("최종 우승자 : ");

    private String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
