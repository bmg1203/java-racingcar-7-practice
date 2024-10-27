package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.UserInputDTO;
import racingcar.exception.InputValidator;

public class InputView {

    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMSTAGES_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static UserInputDTO getUserInput() {
        return new UserInputDTO(getNameInput(), getNumStagesInput());
    }

    private static String getNameInput() {
        System.out.println(NAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    private static long getNumStagesInput() {
        System.out.println(NUMSTAGES_INPUT_MESSAGE);
        String numStages = Console.readLine();
        InputValidator.isRightNumber(numStages);
        return Long.parseLong(numStages);
    }
}
