package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputFormatter {

    private final static String DELIMITER = ",";

    public static List<String> getFormattedCarNames(String carInput) {
        List<String> beforeConvertCars = new ArrayList<>();
        if (carInput != null) {
            String[] carNames = carInput.split(DELIMITER);
            beforeConvertCars = Arrays.stream(carNames).map(String::trim).toList();
        }
        Validator.validateCarNames(beforeConvertCars);
        return beforeConvertCars;
    }

    public static int getFormattedCount(String countInput) {
        Validator.validateCount(countInput);
        return Integer.parseInt(countInput);
    }
}
