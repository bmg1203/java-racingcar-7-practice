package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private static final int MIN_RANDOM_NUMBER_RANGE = 0;
    private static final int MAX_RANDOM_NUMBER_RANGE = 9;

    private NumberGenerator(){
    }

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER_RANGE, MAX_RANDOM_NUMBER_RANGE);
    }
}
