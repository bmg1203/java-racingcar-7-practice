package racingcar.constants;

public enum InputPrompts {

    CAR_NAME_INPUT("경주할 자동차 이름을 입력하세요.(이름은쉼표(,) 기준으로구분)"),
    TRY_COUNT_INPUT("시도할 횟수는 몇 회인가요?");

    private final String inputPrompt;

    InputPrompts(String inputPrompt) {
        this.inputPrompt = inputPrompt;
    }

    public String getInputPrompt() {
        return inputPrompt;
    }
}
