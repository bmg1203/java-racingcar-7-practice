package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.constants.InputPrompts;
import racingcar.utils.Split;
import racingcar.validator.InputValidator;

public class InputView {

    public List<String> inputCarNames() {
        System.out.println(InputPrompts.CAR_NAME_INPUT.getInputPrompt());
        String input = Console.readLine();
        List<String> names = Split.commaSplit(input);

        InputValidator.validateDuplicateName(names);
        return names;
    }

    public int inputTryCount() {
        System.out.println(InputPrompts.TRY_COUNT_INPUT.getInputPrompt());
        String input = Console.readLine();

        return InputValidator.validateTryCount(input);
    }
}
