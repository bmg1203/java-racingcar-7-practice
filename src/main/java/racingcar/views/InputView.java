package racingcar.views;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Validator;

public class InputView {
    private static final String INPUT_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MSG = "시도할 횟수는 몇 회인가요?";

    public static String inputString() {
        System.out.println(INPUT_MSG);
        String input = Console.readLine();
        Validator.validateInput(input);
        return input;
    }

    public static int inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_MSG);
        String input = Console.readLine();
        Validator.validateTryCount(input);
        return Integer.parseInt(input);
    }
}
