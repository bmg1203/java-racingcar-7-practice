package racingcar.ui.reader;

import racingcar.ui.UserInputRequester;

import java.util.Arrays;
import java.util.List;

public class InputReader {
    private final UserInputRequester userInput;

    private final String NAME_DELIMITER = ",";
    private final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String MOVEMENT_ATTEMPT_PROMPT = "시도할 횟수는 몇 회인가요?";

    public InputReader(UserInputRequester userInputRequester) {
        userInput = userInputRequester;
    }

    public List<String> readNames() {
        return splitNames(userInput.request(CAR_NAME_PROMPT));
    }

    public int readMovementAttempts() {
        try {
            return Integer.parseInt(userInput.request(MOVEMENT_ATTEMPT_PROMPT));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 입력");
        }
    }

    private List<String> splitNames(String line) {
        return Arrays.stream(line.split(NAME_DELIMITER)).toList();
    }
}
