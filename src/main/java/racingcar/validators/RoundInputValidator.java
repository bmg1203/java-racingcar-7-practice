package racingcar.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoundInputValidator implements Validator {
    private static final String TYPE_ERROR = "시도할 횟수는 소수점이 없는 양수여야 합니다.";

    @Override
    public void validate(String input) {
        checkInputType(input);
    }

    private void checkInputType(String input) {
        Pattern inputPattern = Pattern.compile("^[1-9][0-9]*$");
        Matcher matcher = inputPattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }
}
