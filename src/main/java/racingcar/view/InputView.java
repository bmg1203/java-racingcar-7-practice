package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_COUNT_MESSAGE = "시도할 회수는 몇 회인가요?";

    public static String getNames() {
        System.out.println(INPUT_NAME_MESSAGE);
        return Console.readLine();
    }

    public static int getCount() {
        System.out.println(INPUT_COUNT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

}
