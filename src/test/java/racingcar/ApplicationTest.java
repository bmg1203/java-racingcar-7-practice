package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName("테스트 : 공백을 포함한 이름")
    void 테스트_이름_공백포함이름() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,  juu n ", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "juu n : -", "최종 우승자 : pobi, juu n");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("예외: 자동차 이름에 공백이 있는 경우")
    void 예외_테스트_이름_공백() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi, , woni", "5"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("예외: 자동차 이름에 \\n이 있는 경우")
    void 예외_테스트_이름_줄바꿈() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi, \n , woni", "5"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("테스트: 0번 입력 시")
    void 테스트_시도횟수_0번일때() {
        assertSimpleTest(
                () -> {
                    run(" pobi,woni ", "0");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                }
        );
    }

    @Test
    @DisplayName("테스트: 시도횟수 \\n 입력시")
    void 테스트_시도횟수_엔터일때() {
        assertSimpleTest(
                () -> {
                    run(" pobi,woni ", "\n");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                }
        );
    }

    @Test
    @DisplayName("예외: 시도횟수 실수 입력 시")
    void 예외_테스트_시도횟수_DOUBLE일때() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi, woni, mirim", "1.0"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("예외: 시도횟수 음수 입력 시")
    void 예외_테스트_시도횟수_음수일때() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi, woni, mirim", "-1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }



}
