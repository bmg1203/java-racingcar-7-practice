package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static String getInputData() {
        System.out.println(GAME_START_MESSAGE);
        return Console.readLine();
    }

    public static String getInputCountData() {
        System.out.println(COUNT_MESSAGE);
        return Console.readLine();
    }
}
