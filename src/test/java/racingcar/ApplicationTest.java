package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "4");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }
    
    @Test
    void 자동차_이름_길이_초과_테스트() {
    	String input = "pobi,woni,longlongname";
    	
    	assertThatThrownBy(() -> Application.validateCarNames(input))
    			.isInstanceOf(IllegalArgumentException.class);	
    }
    
    @Test
    void 시도_횟수_입력_초과_예외_테스트() {
    	String input = "0";
    	
    	assertThatThrownBy(() -> Application.checkMoveSet(input))
				.isInstanceOf(IllegalArgumentException.class);	
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
