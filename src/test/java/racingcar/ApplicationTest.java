package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.InputHandler;
import racingcar.model.Car;
import racingcar.view.InputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void 한개_이하_이름(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.notOneName(InputHandler.getCarNameList());
        });
    }

    @Test
    void 다섯_글자_초과_이름(){
        ArrayList<String> carNameList = new ArrayList<>(List.of("abcdef"));
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.notOverFiveLetter(carNameList);
        });
    }

    @Test
    void 완전하지_않은_낱말(){
        ArrayList<String> carNameList = new ArrayList<>(List.of("ㅁ불완전ㅇ"));
        assertThrows(IllegalArgumentException.class,() -> {
            InputValidator.notCompleteKoreanName(carNameList);
        });
    }

    @Test
    void 콤마_사용_안함(){
        String carName = "not use comma";
        assertThrows(IllegalArgumentException.class, () ->{
           InputValidator.notUseComma(carName);
        });
    }

    @Test
    void 이름_작성_안함(){
        ArrayList<String> carNameList = new ArrayList<>(List.of(""," ","불가"));
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.notWriteLetter(carNameList);
        });
    }

    @Test
    void 양수_아님(){
        int roundNumber = -3;
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.notPositiveNum(roundNumber);
        });
    }

    class FakeInputView extends InputView {
        @Override
        public String inputCarName() {
            return "car1,car2,car3";
        }
    }

    @Test
    void handleCarNames_쉼표구분자_이름리스트변환() {
        FakeInputView fakeInputView = new FakeInputView();
        ArrayList<String> result = InputHandler.handleCarNames(fakeInputView);

        assertEquals(Arrays.asList("car1", "car2", "car3"), result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
