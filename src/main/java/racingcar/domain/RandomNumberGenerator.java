package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(0, 10);
    }

}
