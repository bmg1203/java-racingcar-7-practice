package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomValue {

    private static final int MIN = 0;
    private static final int MAX = 9;

    public static int generate() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
