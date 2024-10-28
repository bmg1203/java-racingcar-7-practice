package racingcar.racingapp.model.car.carEngine;

import camp.nextstep.edu.missionutils.Randoms;

public class RegulationsCarEngine implements CarEngine {

    public static final int WEIGHT_STANDARD_FOR_DRIVING = 4;

    @Override
    public boolean attemptDriveEngine() {
        int weighted = Randoms.pickNumberInRange(0, 9);
        if (weighted < WEIGHT_STANDARD_FOR_DRIVING) {
            return false;
        }
        return true;
    }

}
