package racingcar.view;

import static racingcar.common.constant.GameMessages.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String executeNameInput() {
        printMessage(INPUT_GUIDE_NAME_MESSAGE);
        return input();
    }

    public String executeRoundInput() {
        printMessage(INPUT_GUIDE_ROUND_MESSAGE);
        return input();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String input() {
        return Console.readLine();
    }
}
