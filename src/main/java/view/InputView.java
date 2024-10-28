package view;

import camp.nextstep.edu.missionutils.Console;
import util.Constants;
import util.StringValidator;

public class InputView {
    public static String[] inputWindow(){
        String carNames = inputString(Constants.NOTICE_INPUT_CAR_NAME);
        String tryCount = inputString(Constants.NOTICE_INPUT_TRY_COUNT);

        StringValidator.checkNotNull(carNames);
        StringValidator.checkNotNull(tryCount);
        StringValidator.checkCarNames(carNames);
        StringValidator.checkPositiveIntValue(tryCount);

        return new String[]{carNames, tryCount};
    }

    private static String inputString(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }
}
