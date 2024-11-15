package racingcar.validator;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public static void validateDuplicateName(List<String> names) {
        List<String> validateNames = new ArrayList<>();

        for (String name : names) {
            if (validateNames.contains(name)) {
                throw new IllegalArgumentException();
            }
            validateNames.add(name);
        }
    }

    public static int validateTryCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateEmptyList(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
