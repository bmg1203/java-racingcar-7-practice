package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Constant;

public class RandomGenerator implements NumberGenerator {

    @Override
    public int generator() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
