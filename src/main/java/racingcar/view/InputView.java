package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView INPUT_VIEW = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return INPUT_VIEW;
    }

    public String requestString(OutputView outputView, String message) {
        if (!message.isBlank()) {
            outputView.printLine(message);
        }
        return Console.readLine();
    }

    public void close() {
        Console.close();
    }
}
