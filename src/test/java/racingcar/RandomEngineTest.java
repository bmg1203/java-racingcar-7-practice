package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomEngineTest {

    @Test
    void 랜덤_엔진은_임계치를_넘으면_전진한다() {
        //given
        int moveDistance = 1;
        Engine engine = new RandomEngine(moveDistance);

        //when
        int accelerate = engine.accelerate();

        //then
        Assertions.assertThat(accelerate).isIn(0, moveDistance);
    }
}
