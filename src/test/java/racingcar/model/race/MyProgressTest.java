package racingcar.model.race;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.helper.ReflectionUtil.forceSetField;

import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyProgressTest {

    @Test
    @DisplayName("Lap을 모두 완주한 경우")
    void completeAllLap() {
        // given
        Lap lap = Lap.ZERO;
        Position position = Position.initiate();
        MyProgress myProgress = MyProgress.initiate(lap, position);
        // when
        boolean actual = myProgress.completedAllLap();
        // then
        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("Lap을 모두 완주하지 못한 경우")
    void failedToCompleteAllLap() {
        // given
        Lap lap = Lap.of(BigInteger.valueOf(1));
        Position position = Position.initiate();
        MyProgress myProgress = MyProgress.initiate(lap, position);
        // when
        boolean actual = myProgress.completedAllLap();
        // then
        assertThat(actual).isEqualTo(false);
    }

    @Test
    @DisplayName("총 5바퀴 중 3바뀌 남았을 때")
    void test() {
        // given
        Lap remainingLap = Lap.of(BigInteger.valueOf(3));
        Position position = Position.initiate();
        forceSetField(position, "value", "---");
        MyProgress myProgress = MyProgress.initiate(remainingLap, position);
        // when
        myProgress.updateRemainingLap();
        myProgress.updatePositionBy(1);
        // then
        assertThat(myProgress.toString()).isEqualTo("----");
    }
}
