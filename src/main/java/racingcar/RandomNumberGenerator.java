package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
