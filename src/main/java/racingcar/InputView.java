package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        List<String> carNames = Arrays.stream(carNameInput.split(",",-1)).map(String::trim).toList();
        validateCarNames(carNames);

        System.out.println(carNames);

        return carNames;
    }

    public static int readRaceCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int raceCount = Integer.parseInt(Console.readLine());
            validateRaceCount(raceCount);
            return raceCount;
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            if (carName.isBlank()) throw new IllegalArgumentException("자동차 이름으로 빈 문자열이 올 수 없습니다.");
        }
    }

    private static void validateRaceCount(int raceCount) {
        if (raceCount <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 1회 이상이어야 합니다.");
        }
    }
}
