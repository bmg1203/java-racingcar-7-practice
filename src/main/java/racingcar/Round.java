package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Round {
    private final Map<Car, Integer> roundResult = new HashMap<>();
    private final int moveCount;

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private void validate(String Input) {
        if (!isNumeric(Input)) {
            throw new IllegalArgumentException("횟수는 숫자만 가능합니다.");
        } else {
            int parsedInput = Integer.parseInt(Input);
            if (parsedInput <= 0 || parsedInput > 80) {
                throw new IllegalArgumentException("횟수는 1 이상 80 이하의 숫자만 가능합니다.");
            }
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public Round(String moveCountInput, List<Car> cars) {
        validate(moveCountInput);
        moveCount = Integer.parseInt(moveCountInput);
        for (Car car : cars) {
            roundResult.put(car, 0);
        }
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (canMove()) {
                roundResult.put(car, roundResult.get(car) + 1);
            }
        }
    }

    public void progress(List<Car> cars) {
        for (int i = 0; i < moveCount; i++) {
            moveCars(cars);
        }
    }

    public Map<Car, Integer> getRoundResult() {
        return roundResult;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
