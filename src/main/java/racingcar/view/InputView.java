package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.UserInputDTO;

import java.util.Scanner;

public class InputView {

    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMSTAGES_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static UserInputDTO getUserInput() {
        return new UserInputDTO(getNameInput(), getNumStagesInput());
    }

    private static String getNameInput() {
        System.out.println(NAME_INPUT_MESSAGE);
//        return Console.readLine();
        return scanner.nextLine();
    }

    private static int getNumStagesInput() {
        System.out.println(NUMSTAGES_INPUT_MESSAGE);
//        return Integer.parseInt(Console.readLine());
        return Integer.parseInt(scanner.nextLine());
    }
}
