package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    public void start() {
        String carNamesInput = inputCarNames();
        int raceAttempts = inputRaceAttempts();
        validateCarNames(carNamesInput);
        validateRaceAttempts(raceAttempts);
    }

    private String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private int inputRaceAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수는 숫자로 입력해야 합니다.");
        }
    }

    private void validateCarNames(String carNamesInput) {
        List<String> carNames = Arrays.asList(carNamesInput.split(","));
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private void validateRaceAttempts(int raceAttempts) {
        if (raceAttempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}