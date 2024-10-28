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

    @Test
    @DisplayName("라운드 숫자가 잘못된 경우")
    void wrongRoundNumber() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "3 "))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    @DisplayName("공동 우승자가 있는 경우")
    void winTogether () {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "4");
                    assertThat(output()).contains("pobi : --", "woni : --", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("자동차 이름이 공백인 경우")
    void blankName() {
        assertSimpleTest(() ->
             assertThatThrownBy(() -> runException("        ", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    @DisplayName("자동차 이름 여러개중 하나가 공백인 경우")
    void blankName2 () {
        assertSimpleTest(() ->
             assertThatThrownBy(() -> runException("pobi,woni, ", "1"))
                 .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 중복될 경우")
    void duplicatedName () {
        assertSimpleTest(() ->
             assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                 .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    @DisplayName("자동차 이름이 5글자 초과인 경우")
    void moreThan5Letters () {
        assertSimpleTest(() ->
             assertThatThrownBy(() -> runException("pobi,woni,pooooooobi", "1"))
                 .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    @DisplayName("라운드 번호가 공백인 경우")
    void roundNumBlank () {
        assertSimpleTest(() ->
             assertThatThrownBy(() -> runException("pobi,woni", " "))
                 .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("라운드 번호가 음수인 경우")
    void roundNumPositive () {
        assertSimpleTest(() ->
             assertThatThrownBy(() -> runException("pobi,woni", "-2"))
                 .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("라운드 번호가 0인 경우")
    void roundNum0 () {
        assertSimpleTest(() ->
             assertThatThrownBy(() -> runException("pobi,woni", "0"))
                 .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
