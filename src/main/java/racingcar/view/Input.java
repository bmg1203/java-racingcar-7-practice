package racingcar.view;

import static racingcar.domain.ErrorMessage.ATTEMPT_ONLY_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            return Console.readLine();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int inputAttemptNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPT_ONLY_NUMBER.getMessage());
        }
    }

}
