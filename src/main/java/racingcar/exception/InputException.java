package racingcar.exception;

public enum InputException {
    INPUT_IS_NULL_OR_EMPTY("입력값이 비어있거나 null입니다."),
    NAME_IS_EMPTY("이름이 빈 값이 포함되어 있습니다.");

    private final String message;

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
