package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String readCarNames() {
        OutputView.printInputCarNames();
        return Console.readLine();
    }

    public static String readAttempts() {
        OutputView.printInputAttempts();
        return Console.readLine();
    }

}
