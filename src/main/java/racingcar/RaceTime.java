package racingcar;

import static racingcar.ErrorMessage.INVALID_RACE_TIME;
import static racingcar.ErrorMessage.NEGATIVE_RACE_TIME;

public class RaceTime {
    private int remainingTime;

    public RaceTime(String timeInString) {
        int remainingTime = parseInt(timeInString);
        if (remainingTime < 0) {
            throw new IllegalArgumentException(NEGATIVE_RACE_TIME.getMessage());
        }

        this.remainingTime = remainingTime;
    }

    private static int parseInt(String intInString) {
        try {
            return Integer.parseInt(intInString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_RACE_TIME.getMessage());
        }
    }

    public boolean isRemaining() {
        return this.remainingTime-- > 0;
    }
}
