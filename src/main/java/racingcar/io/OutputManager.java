package racingcar.io;

import java.util.List;
import racingcar.message.IOMessage;

public class OutputManager {
    public static void printEnterCarNameMessage() {
        System.out.println(IOMessage.ENTER_CAR_NAME_INPUT);
    }

    public static void printEnterAttemptCountMessage() {
        System.out.println(IOMessage.ENTER_ATTEMPT_COUNT_INPUT);
    }

    public static void printExecutionResult(String executionResult) {
        System.out.println(IOMessage.EXECUTION_RESULT_OUTPUT);
        System.out.println(executionResult);
    }

    public static void printWinnerResult(List<String> winners) {
        System.out.println(IOMessage.WINNER_RESULT_OUTPUT + String.join(", ", winners));
    }
}
