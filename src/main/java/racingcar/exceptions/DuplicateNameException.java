package racingcar.exceptions;

public class DuplicateNameException extends IllegalArgumentException {
    public DuplicateNameException(String message) {
        super(message);
    }
}
