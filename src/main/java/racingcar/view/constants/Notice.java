package racingcar.view.constants;

public enum Notice {
    ASK_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_TOTAL_ROUNDS("시도할 횟수는 몇 회인가요?"),
    EXCUTOIN_NOTICE("실행 결과"),
    WINNER_NOTICE("최종 우승자 : ");

    private final String message;

    Notice(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
