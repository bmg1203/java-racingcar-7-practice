package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TURN_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String DELIMITER = ",";

    public List<String> inputCarName() {
        DisplayInputPrompt(INPUT_CAR_MESSAGE);
        String carNamePart = readUserInput();
        final List<String> carNames = parseCarNames(carNamePart);
        validateCarName(carNames);

        return carNames;
    }

    public int inputRacingTurn() {
        DisplayInputPrompt(INPUT_TURN_MESSAGE);
        String rawTurn = readUserInput();
        validateTurn(rawTurn);

        return parseTurn(rawTurn);
    }

    private String readUserInput() {
        return Console.readLine();
    }

    private void DisplayInputPrompt(String prompt) {
        System.out.println(prompt);
    }

    private List<String> parseCarNames(String carNamePart) {
        return Arrays.stream(carNamePart.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    private void validateCarName(List<String> carNames) {
        for (String carName : carNames) {
            validateNoneInput(carName);
        }
    }

    private void validateTurn(String rawTurn) {
        validateNoneInput(rawTurn);
        validateDigit(rawTurn);
        validatePositiveInteger(rawTurn);
    }

    private int parseTurn(String rawTurn) {
        try {
            return Integer.parseInt(rawTurn);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("2,147,483,647 미만 정수로 입력해 주세요");
        }
    }

    private void validateNoneInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("공백 입력은 불가합니다.");
        }
    }

    private void validateDigit(String input) {
        for (char digit : input.toCharArray()) {
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException("양의 정수만 입력 해주세요");
            }
        }
    }

    private void validatePositiveInteger(String input) {
        if (parseTurn(input) <= 0) {
            throw new IllegalArgumentException("양의 정수만 입력해 주세요");
        }
    }
}
