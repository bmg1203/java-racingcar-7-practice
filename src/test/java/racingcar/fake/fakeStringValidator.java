package racingcar.fake;

import racingcar.util.StringValidator;

public class fakeStringValidator implements StringValidator {

    @Override
    public void validateFormat(final String value) {
        // fake
    }

    @Override
    public void validateLength(final String value, final int maxLength) {
        // fake
    }
}
