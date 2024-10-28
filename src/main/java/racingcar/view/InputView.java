package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validate.InputNumberValidation;
import racingcar.view.enums.ViewMessages;

public class InputView {

    private final InputNumberValidation inputNumberValidation = new InputNumberValidation();

    public String enterCarNames() {
        System.out.println(ViewMessages.ENTER_CAR_NAMES.getViewMessages());
        return Console.readLine();
    }

    public String enterNumberOfAttempts() {
        System.out.println(ViewMessages.ENTER_NUMBER_OF_ATTEMPTS.getViewMessages());
        String inputNumber = Console.readLine();
        inputNumberValidation.validateInputNumber(inputNumber);
        return inputNumber;
    }
}
