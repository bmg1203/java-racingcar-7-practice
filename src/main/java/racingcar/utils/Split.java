package racingcar.utils;

import java.util.List;

public class Split {

    private static final String COMMA = ",";

    public static List<String> commaSplit(String input) {
        return List.of(input.split(COMMA));
    }
}
