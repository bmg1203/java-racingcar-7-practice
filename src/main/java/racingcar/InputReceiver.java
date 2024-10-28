package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.NoSuchElementException;

public class InputReceiver {

    private final InputParser inputParser;

    public InputReceiver(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readInput();

        return inputParser.splitToCars(input);
    }

    public long readAttemptNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = readInput();

        return inputParser.parseAttemptNumber(input);
    }

    private String readInput() {
        try {
            String input = Console.readLine();
            validateInput(input);

            return input;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
    }
}
