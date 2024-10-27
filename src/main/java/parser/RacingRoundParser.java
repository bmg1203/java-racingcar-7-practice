package parser;

import validator.Validator;

public class RacingRoundParser {
    private final Validator validator;

    public RacingRoundParser(Validator validator) {
        this.validator = validator;
    }

    public int parseRacingRound(String input) {
        validator.validateRound(input);
        return Integer.parseInt(input);
    }
}
