package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String inputCarNames() {
        return Console.readLine().trim();
    }

    public static String inputTryCount() {
        return Console.readLine().trim();
    }
}
