package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //입력 관련 테스트
    @ParameterizedTest
    @ValueSource(strings = {"pobi,javaji", "", " ", ",", "pobi,pobi"})
    void 이름_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", " ", "\n", "-1", "t"})
    void 시도회수_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //결과 관련 테스트
    @Test
    void 시도_한번_우승자_한명_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : -", "최종 우승자 : woni");
                },
                STOP, MOVING_FORWARD
        );
    }

    @Test
    void 시도_한번_우승자_여러명_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 시도_여러번_우승자_한명_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains("pobi : -", "woni : -", "jun : ");
                    assertThat(output()).contains("pobi : --", "woni : -", "jun : ");
                    assertThat(output()).contains("pobi : --", "woni : --", "jun : -");
                    assertThat(output()).contains("pobi : ---", "woni : ---", "jun : -");
                    assertThat(output()).contains("pobi : ----", "woni : ---", "jun : -");
                    assertThat(output()).contains("최종 우승자 : pobi");

                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, STOP,
                STOP, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 시도_여러번_우승자_여러명_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : -", "woni : -", "jun : -");
                    assertThat(output()).contains("pobi : --", "woni : -", "jun : -");
                    assertThat(output()).contains("pobi : --", "woni : -", "jun : --");
                    assertThat(output()).contains("최종 우승자 : pobi, jun");

                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, STOP,
                STOP, STOP, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
