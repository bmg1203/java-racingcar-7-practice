package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.NullEmptyStringException;

public class InputManager {
    private static final InputManager inputManager = new InputManager();

    private InputManager() {
    }

    public static InputManager getInstance() {
        return inputManager;
    }

    private static String validateInput(final String input) {
        if (input == null || input.isBlank()) {
            throw new NullEmptyStringException();
        }
        return input;
    }

    public String carNameInput() {
        OutputManager.printEnterCarNameMessage();
        return validateInput(Console.readLine());
    }

    public String attemptCountInput() {
        OutputManager.printEnterAttemptCountMessage();
        return validateInput(Console.readLine());
    }
}
