package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class InputView {
    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회인가요?";

    public static String getListOfCarNames(){
        System.out.println(INPUT_CAR_MESSAGE);
        String carNames = Console.readLine();
        InputValidator.validateInput(carNames);
        return carNames;
    }

    public static String getInputNumberOfAttempts(){
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS);
        String numberOfAttempts = Console.readLine();
        InputValidator.validateInput(numberOfAttempts);
        return numberOfAttempts;
    }
}
