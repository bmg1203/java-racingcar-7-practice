package racingcar.process;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

class MovePolicyTest {
    @Test
    @DisplayName("랜덤 값에 따른 전진 테스트")
    void movePolicyTest() {
        MovePolicy policy = new MovePolicy();
        List<Boolean> actual = new ArrayList<>();
        List<Boolean> expected = List.of(false, false, false, false, true, true, true, true, true, true);

        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        actual.add(policy.run());
                    }
                    assertIterableEquals(expected, actual);
                },
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        );
    }
}