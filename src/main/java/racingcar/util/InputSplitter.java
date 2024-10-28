package racingcar.util;

import java.util.Arrays;
import racingcar.model.CarNames;

public class InputSplitter {
    private static final String DELIMETER = ",";

    private InputSplitter() {
    }

    public static CarNames split(String input) {
        return new CarNames(
                Arrays.stream(input.split(DELIMETER))
                        .map(String::trim)
                        .toList());
    }
}
