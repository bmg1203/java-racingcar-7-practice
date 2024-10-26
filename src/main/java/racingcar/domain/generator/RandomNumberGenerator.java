package racingcar.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    static final int MIN = 0;
    static final int MAX = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
