package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerateNumberStrategy implements GenerateNumberStrategy {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
