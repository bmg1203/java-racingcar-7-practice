package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.Split;
import racingcar.validator.InputValidator;

public class InputView {

    public List<String> inputCarNames() {
        String input = Console.readLine();
        List<String> names = Split.commaSplit(input);

        InputValidator.validateDuplicateName(names);
        return names;
    }
}
