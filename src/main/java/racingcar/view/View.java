package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class View {

    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static String requestCarNames() {
        printlnMessage(REQUEST_CAR_NAMES_MESSAGE);
        String names = enterMessage();
        Validator.validateCarNames(names);
        return names;
    }

    private static void printlnMessage(String message) {
        System.out.println(message);
    }

    private static String enterMessage() {
        return Console.readLine();
    }

    public static class Validator {
        public static void validateCarNames(String input) {
            List<String> names = Arrays.asList(input.split(","));
            isNotEmpty(names);
            isWithinLengthLimit(names);
            isAlphabetic(names);
            hasMinimumCars(names);
            hasNoDuplicates(names);
        }

        private static void isNotEmpty(List<String> names) {
            for (String name : names) {
                if (name.trim().isEmpty()) {
                    throw new IllegalArgumentException("자동차 이름이 비어 있습니다.");
                }
            }
        }

        private static void isWithinLengthLimit(List<String> names) {
            for (String name : names) {
                if (name.length() > 5) {
                    throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
                }
            }
        }

        private static void isAlphabetic(List<String> names) {
            for (String name : names) {
                if (!name.matches("[a-zA-Z]+")) {
                    throw new IllegalArgumentException("자동차 이름은 알파벳만 포함해야 합니다.");
                }
            }
        }

        private static void hasMinimumCars(List<String> names) {
            if (names.size() < 2) {
                throw new IllegalArgumentException("자동차는 2대 이상 입력해야 합니다.");
            }
        }

        private static void hasNoDuplicates(List<String> names) {
            Set<String> uniqueNames = new HashSet<>(names);
            if (uniqueNames.size() != names.size()) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
            }
        }
    }
}