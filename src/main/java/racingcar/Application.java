package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 1. 자동차 이름 입력 및 검증
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();
        List<String> validateNames = InputValidator.validateNames(input);
    }
}
