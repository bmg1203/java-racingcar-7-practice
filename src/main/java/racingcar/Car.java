package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private String name;
    private List<CarMovementState> movementLog = new ArrayList<>();
    private int moveCount = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
        }
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            movementLog.add(CarMovementState.MOVE);
            moveCount++;
        } else {
            movementLog.add(CarMovementState.STOP);
        }
    }

    public List<CarMovementState> getMovementLog(int attempt) {
        return movementLog.subList(0, attempt);
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
