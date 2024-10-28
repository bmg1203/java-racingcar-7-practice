package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

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
    void 시작_안내_문구_테스트() {
        Application.printStartMessage();

        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",outputStream.toString()
                .trim());
    }

    @Test
    void 시작_안내_문구_틀린경우_테스트() {
        Application.printStartMessage();

        assertNotEquals("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)",outputStream.toString()
                .trim());
    }

    @Test
    void 시도_횟수_안내_문구_테스트(){
         Application.printTryCountMessage();

         assertEquals("시도할 횟수는 몇 회인가요?", outputStream.toString()
                 .trim());
    }

    @Test
    void 시도_횟수_안내_문구_틀린_경우_테스트(){
        Application.printTryCountMessage();

        assertNotEquals("시도할 회수는 몇 회인가요?", outputStream.toString()
                .trim());
    }

    @Test
    void 빈_칸_입력_예외처리_테스트(){
        assertThrows(IllegalArgumentException.class, () -> Application.validateEmptyInput(""));
        assertThrows(IllegalArgumentException.class, () -> Application.validateEmptyInput(" "));
        assertThrows(IllegalArgumentException.class, () -> Application.validateEmptyInput("     "));
        assertThrows(IllegalArgumentException.class, () -> Application.validateEmptyInput(" "));
    }

    @Test
    void 빈_칸이_아닌_정상입력_예외처리_테스트(){
        assertDoesNotThrow(() -> Application.validateEmptyInput("abcd"));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
