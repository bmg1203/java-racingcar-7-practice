package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Utils {
    public static int generateRandomValue() {
        return pickNumberInRange(0, 9);
    }

    public static boolean checkMoveCondition(int randomNum) {
        return randomNum >= 4;
    }

}
