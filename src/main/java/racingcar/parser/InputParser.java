package racingcar.parser;

public class InputParser {

    private final String INPUT_SEPARATOR = ",";

    public String[] splitInput(String input) {
        return input.split(INPUT_SEPARATOR);
    }

    public int parseInt(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }
}
