package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.InputRequest;

public class InputView {

    private InputView() {
    }

    public static InputRequest readLine() {
        String inputCarNames = readCarNames();
        int inputMovingCount = readMovingCount();

        Console.close();

        return new InputRequest(inputCarNames, inputMovingCount);
    }

    private static int readMovingCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
        String inputMovingCount = Console.readLine();
        isInvalidInput(inputMovingCount);
        return parseInt(inputMovingCount);
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자나 정수 범위를 넘어가는 숫자는 입력하실 수 없습니다.");
        }
    }

    private static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        isInvalidInput(inputCarNames);
        return inputCarNames;
    }

    private static void isInvalidInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력하셨습니다");
        }
    }
}
