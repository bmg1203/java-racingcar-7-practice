package racingcar.race;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.race.model.Cars;

public class RacingGame {

    private static final String CAR_NAME_TO_ENTER_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_OF_ATTEMPTS_TO_ENTER_TEXT = "시도할 횟수는 몇 회인가요?";
    private static final String ERROR_MESSAGE_IF_IT_IS_NOT_A_NUMBER = "숫자를 입력해야합니다.";
    private static final String EXECUTION_RESULT_TEXT = System.lineSeparator() + "실행결과";
    private static final String WINNER_TEXT = System.lineSeparator() + "최종 우승자 : ";
    private static final String NAME_RULE_DELIMITER = ",";

    public void start() {
        Cars cars = Cars.of(inputNames());
        int round = inputRound();
        executeRound(cars, round);
        displayWinners(cars);
    }

    private static void displayWinners(Cars cars) {
        System.out.print(WINNER_TEXT);
        String winners = cars.getWinners();
        System.out.println(winners);
    }

    private static void executeRound(Cars cars, int round) {
        System.out.println(EXECUTION_RESULT_TEXT);
        String executionResult = cars.getExecutedRound(round);
        System.out.println(executionResult);
    }

    private List<String> inputNames() {
        System.out.println(CAR_NAME_TO_ENTER_TEXT);

        return Arrays.stream(Console.readLine().split(NAME_RULE_DELIMITER))
                .map(String::trim)
                .toList();
    }

    private int inputRound() {
        System.out.println(NUMBER_OF_ATTEMPTS_TO_ENTER_TEXT);

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_IF_IT_IS_NOT_A_NUMBER);
        }
    }
}
