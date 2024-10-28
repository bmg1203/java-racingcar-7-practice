package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementGeneratorTest {
    /** 테스트 클래스 명 -> [메서드 명]_[테스트 중 상태]_[기대 행위] **/
    @Test
    @DisplayName("랜덤한 움직임이 반환되는지 테스트")
    void getRandomMovement_MethodCall_gotMovement() {
        //when
        Movement movement = MovementGenerator.getRandomMovement();

        //then
        assertThat(movement).isIn(Movement.GO, Movement.STOP);
    }
}
