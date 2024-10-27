package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;
import racingcar.service.collection.RacingCar;

public class Game {

    public void start(RacingCar racingCar) {
        final Set<String> allRacingCarName = racingCar.getAllRacingCarName();

        for (String eachCarName : allRacingCarName) {
            final int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= 4) {
                racingCar.moveForward(eachCarName);
            }
        }
    }
}
