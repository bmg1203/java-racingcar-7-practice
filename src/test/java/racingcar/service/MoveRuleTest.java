package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.util.FixedNumberGenerator;

public class MoveRuleTest {
    private static final int FORWARD = 1;
    private static final int STOP = 0;
    private ThresholdScoreMoveRule moveRule;

    @Test
    void 전진_테스트() {
        moveRule = new ThresholdScoreMoveRule(new FixedNumberGenerator(4));
        int result = moveRule.tryMove();
        assertThat(result).isEqualTo(FORWARD);
    }

    @Test
    void 멈춤_테스트() {
        moveRule = new ThresholdScoreMoveRule(new FixedNumberGenerator(3));
        int result = moveRule.tryMove();
        assertThat(result).isEqualTo(STOP);
    }
}
