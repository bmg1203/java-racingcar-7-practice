package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Racing {
    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }

    public void racing(List<Car> cars) {
        for (Car car : cars) {
            if (canMove()) car.move();
        }
    }

    public int compareMoveCount(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }
}
