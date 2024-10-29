package racingcar.domain;

public class RacingRule {
    private static final int MINIMUM_ADVANCE_VALUE = 4;

    public boolean canAdvance(int randomValue) {
        return randomValue >= MINIMUM_ADVANCE_VALUE;
    }
}