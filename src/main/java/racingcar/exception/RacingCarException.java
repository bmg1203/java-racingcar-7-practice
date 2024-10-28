package racingcar.exception;

public class RacingCarException extends IllegalArgumentException {
    private RacingCarException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static RacingCarException from(ErrorMessage errorMessage) {
        return new RacingCarException(errorMessage);
    }
}
