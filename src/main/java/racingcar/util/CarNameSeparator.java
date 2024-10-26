package racingcar.util;

import java.util.List;

public class CarNameSeparator {
    private static final String CAR_NAME_SEPARATOR = ",";

    public static List<String> splitCarNameWithSeparator(String carNames) {
        return List.of(carNames.split(CAR_NAME_SEPARATOR, -1));
    }

    public static List<String> splitCarNameWithoutSpace(String carNamesWithSpace) {
        return splitCarNameWithSeparator(carNamesWithSpace)
                .stream()
                .map(String::trim)
                .toList();
    }
}
