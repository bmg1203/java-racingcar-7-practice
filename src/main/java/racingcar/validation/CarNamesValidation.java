package racingcar.validation;

import racingcar.exception.CarNamesErrorMessage;
import racingcar.exception.CarNamesException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CarNamesValidation {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_DELIMITER = ",";

    public static List<String> validateCarNames(String carNames) {
        isCarNamesEmpty(carNames);
        isCarNamesDelimiterValid(carNames);

        return convertCarNamesToList(carNames);
    }

    private static void isCarNamesEmpty(String carNames) {
        if (carNames.isEmpty()) throw new CarNamesException(CarNamesErrorMessage.CAR_NAME_EMPTY);
    }

    private static void isCarNamesDelimiterValid(String carNames) {
        if (!carNames.matches("^[^,;]+(,[^,;]+)*$"))
            throw new CarNamesException(CarNamesErrorMessage.INVALID_DELIMITER);
    }

    private static List<String> convertCarNamesToList(String carNames) {
        List<String> namesList = Arrays.asList(carNames.split(NAME_DELIMITER));

        isCarNameOverFive(namesList);
        isCarNamesDuplicate(namesList);

        return namesList;
    }

    private static void isCarNameOverFive(List<String> names) {
        for (String name : names)
            if (name.length() > MAX_NAME_LENGTH) throw new CarNamesException(CarNamesErrorMessage.CAR_NAME_OVER_FIVE);
    }

    private static void isCarNamesDuplicate(List<String> names) {
        HashSet<String> nameSet = new HashSet<>();

        for (String name : names)
            if (!nameSet.add(name.trim())) throw new CarNamesException(CarNamesErrorMessage.DUPLICATE_CAR_NAME);
    }
}