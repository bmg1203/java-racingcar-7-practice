package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputHandler {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Stream.of(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        if (carNames.size() < 2) {
            throw new IllegalArgumentException("최소 두 대 이상의 자동차 이름을 입력해야 합니다.");
        }

        validateDuplicateNames(carNames);

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
            }
        }

        return carNames;
    }

    public int getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptCount;

        try {
            attemptCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }

        if (attemptCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return attemptCount;
    }

    private void validateDuplicateNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() < carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
