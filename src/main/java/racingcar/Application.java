package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static final String EMPTY_INPUT_MESSAGE = "입력이 비어 있습니다. 자동차 이름을 쉼표로 구분하여 입력해주세요.";
    public static final String COMMA_REQUIRED_MESSAGE = "쉼표(,)로 구분된 이름을 입력해야 합니다.";
    public static final String NAME_EMPTY_MESSAGE = "자동차 이름이 비어 있습니다. 모든 자동차의 이름을 올바르게 입력해주세요.";
    public static final String NAME_LENGTH_OVER_MESSAGE = "자동차 이름 길이는 5자 이하여야 합니다.";
    public static final String MIN_CARS_REQUIRED_MESSAGE = "최소 두 대의 자동차 이름을 입력해야 합니다.";
    public static final String MESSAGE_INVALID_TRY_COUNT = "시도할 횟수는 양수여야 합니다.";
    public static final String MESSAGE_INVALID_NUMBER_FORMAT = "유효한 숫자 형식이 아닙니다.";

    public static void main(String[] args) {
        Map<String, Integer> carPositions = new HashMap<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInput = Console.readLine();
        validateCarNames(carsInput);

        List<String> carNames = Stream.of(carsInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        carNames.forEach(name -> carPositions.put(name, 0));

        System.out.println("시도할 횟수를 입력하세요.");
        String tryCountInput = Console.readLine();
        int tryCount = validateTryCount(tryCountInput);

        for (int i = 0; i < tryCount; i++) {
            moveCars(carPositions);
            printRaceStatus(carPositions);
        }

        List<String> winners = findWinners(carPositions);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static void moveCars(Map<String, Integer> carPositions) {
        carPositions.forEach((name, position) -> {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carPositions.put(name, position + 1);
            }
        });
    }

    private static void printRaceStatus(Map<String, Integer> carPositions) {
        carPositions.forEach((name, position) -> {
            System.out.println(name + " : " + "-".repeat(position));
        });
        System.out.println();
    }

    private static List<String> findWinners(Map<String, Integer> cars) {
        int maxScore = Collections.max(cars.values());
        List<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            if (car.getValue() == maxScore) {
                winners.add(car.getKey());
            }
        }

        return winners;
    }

    public static void validateCarNames(String carsInput) {
        if (carsInput == null || carsInput.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
        }

        if (!carsInput.contains(",")) {
            throw new IllegalArgumentException(COMMA_REQUIRED_MESSAGE);
        }

        String[] carNames = carsInput.split(",");

        if (carNames.length < 2) {
            throw new IllegalArgumentException(MIN_CARS_REQUIRED_MESSAGE);
        }

        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException(NAME_EMPTY_MESSAGE);
            }

            if (name.length() > 5) {
                throw new IllegalArgumentException(NAME_LENGTH_OVER_MESSAGE);
            }
        }
    }

    public static Integer validateTryCount(String tryCountInput) {
        try {
            int tryCount = Integer.parseInt(tryCountInput);

            if (tryCount <= 0) {
                throw new IllegalArgumentException(MESSAGE_INVALID_TRY_COUNT);
            }

            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MESSAGE_INVALID_NUMBER_FORMAT);
        }
    }
}
