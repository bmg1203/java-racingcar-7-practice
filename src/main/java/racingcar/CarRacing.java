package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CarRacing {
    public static List<RacingCar> start(RacingCarTrace racingCarTrace) {
        var tryCount = Prompt.racingTryCount();
        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < racingCarTrace.size(); j++) {
                var racingCar = racingCarTrace.getRacingCar(j);
                var randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    racingCarTrace.forward(racingCar);
                }
            }
            Prompt.tracePrint(racingCarTrace);
        }
        return racingCarTrace.getBiggestDistanceRacingCar();
    }
}