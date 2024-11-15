package racingcar.constants;

public enum OutputPrompts {

    TRY_RESULT_HEADER("실행 결과"),
    TRY_RESULT("%s : %s"),
    FINAL_RESULT("최종 우승자 : %s");

    private final String outputPrompt;

    OutputPrompts(String outputPrompt) {
        this.outputPrompt = outputPrompt;
    }

    public String getOutputPrompt() {
        return outputPrompt;
    }
}
