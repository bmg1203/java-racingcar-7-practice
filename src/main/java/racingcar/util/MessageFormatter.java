package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.InputValidator;

public class MessageFormatter {

    private final static String DELIMITER = ",";

    public static List<String> getFormattedCarNames(String carInput) {
        String[] carNames = carInput.split(DELIMITER);
        List<String> beforeConvertCars = Arrays.stream(carNames).map(String::trim).toList();
        InputValidator.validateCarNames(beforeConvertCars);
        return beforeConvertCars;
    }

    public static int getFormattedCount(String countInput) {
        InputValidator.validateCount(countInput);
        return Integer.parseInt(countInput);
    }

    public static String getWinnersName(List<String> winners) {
        return String.join(", ", winners);
    }

    public static String getCarInformation(String name, int status) {
        return name + " : " + "-".repeat(status);
    }
}
