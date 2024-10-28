package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class CarRacingGame {

    private static final int MAX_NAME_LENGTH = 5;

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));
        validateCarNames(carNames);
        return carNames;
    }

    private static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static int getNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int attempts = validateAttempts(input);
        return attempts;
    }

    private static int validateAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("이동 횟수는 1 이상의 정수여야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
    }
}