package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getInput() {
        String input = Console.readLine();
        Console.close();
        return input;
    }
}
