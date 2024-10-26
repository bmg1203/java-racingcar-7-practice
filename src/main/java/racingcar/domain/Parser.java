package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.InputValidator;

public class Parser {
    private final InputValidator inputValidator = new InputValidator();

    public List<String> parse(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(inputValidator::check)
                .toList();
    }

}
