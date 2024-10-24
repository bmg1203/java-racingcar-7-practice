package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class UIController {

    private static final String QUESTION_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String QUESTION_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String RACE_RESULT = "실행 결과";
    private static final String WINNER_FORMAT = "최종 우승자 : ";
    private static final String NEXT_LINE = "\n";
    private static final String NAME_SEPARATOR_SYMBOL = ",";

    public List<String> receiveName() {
        OutputView.print(QUESTION_CAR_NAME);
        return validateName(InputView.read());
    }

    public int receiveCount() {
        OutputView.print(QUESTION_TRY_COUNT);
        return validateCount(InputView.read());
    }

    public void printRaceResultPhrase() {
        OutputView.print(RACE_RESULT);
    }

    public void printRaceResult(Car car) {
        OutputView.print(car.toString() + NEXT_LINE);
    }

    public void printWinner(Car car) {
        OutputView.print(WINNER_FORMAT + car.getName());
    }

    private List<String> validateName(String input) {
        validateBlank(input);
        validateSeparator(input);

        return split(input, NAME_SEPARATOR_SYMBOL);
    }

    private List<String> split(String input, String separator) {
        return Arrays.stream(input.split(separator))
                .toList();
    }

    private void validateBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("[ERROR]빈 문자열을 입력할 수 없습니다.");
        }
    }

    private boolean isBlank(String input) {
        return input.isBlank();
    }

    private void validateSeparator(String input) {
        validateEdgeSeparator(input);
        validateContinuousSeparator(input);
    }

    private void validateEdgeSeparator(String input) {
        if (isEdgeSeparator(input)) {
            throw new IllegalArgumentException("[ERROR]잘못된 입력 형식입니다.");
        }
    }

    private boolean isEdgeSeparator(String input) {
        return input.startsWith(NAME_SEPARATOR_SYMBOL) || input.endsWith(NAME_SEPARATOR_SYMBOL);
    }

    private void validateContinuousSeparator(String input) {
        if (isContinuousSeparator(input)) {
            throw new IllegalArgumentException("[ERROR]연속된 쉼표는 올 수 없습니다.");
        }
    }

    private boolean isContinuousSeparator(String input) {
        return input.contains(NAME_SEPARATOR_SYMBOL.repeat(2));
    }

    private int validateCount(String count) {
        validateBlank(count);
        return validateNumber(count);
    }

    private int validateNumber(String count) {
        if (isNotPositiveInteger(count)) {
            throw new IllegalArgumentException("[ERROR]횟수는 양의 정수만 입력가능합니다.");
        }
        return Integer.parseInt(count);
    }

    private boolean isNotPositiveInteger(String count) {
        return !count.matches("^[1-9]*$");
    }
}
