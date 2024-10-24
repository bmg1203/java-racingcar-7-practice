package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomRace {

    private boolean isAdvance() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }

    public List<RacingCar> start(List<RacingCar> racingCars, Long tryNums) {
        for (int i = 0; i < tryNums; i++) {
            for (RacingCar racingCar : racingCars) {
                if (isAdvance()) {
                    racingCar.race();
                }
            }
        }
        return racingCars;
    }

}
