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
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 다인_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,test,value,jd", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
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
    void 이름_중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_6글자이상_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj1","1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_공백_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,test","1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_영어_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,1234","1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
