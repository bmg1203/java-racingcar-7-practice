package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final String delimiter = ",";

    private String readLine() {
        return Console.readLine();
    }

    public List<String> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();

        return Arrays.stream(input
                .split(delimiter))
                .toList();
    }

    public int tryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = readLine();

        return Integer.parseInt(input);
    }
}
