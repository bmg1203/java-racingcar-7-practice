package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("시도 횟수 테스트")
class PlayCountControllerTest extends NsTest {
    private PlayCountController playCountController;

    @BeforeEach
    void setUp() {
        this.playCountController = PlayCountController.getInstance();
    }

    @ParameterizedTest
    @ValueSource(strings = {"삼","one","@"})
    @DisplayName("반복 횟수에 숫자가 아닌 것을 입력하면 예외가 발생한다")
    void playCountFormatError(String count) {
        throwException(count);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0","-1","11"})
    @DisplayName("반복 횟수에 0 이하이거나 10 초과 값을 입력하면 예외가 발생한다")
    void playCountLimitError(String count) {
        throwException(count);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","9"})
    @DisplayName("반복 횟수에 1에서 9사이의 숫자를 입력하면 예외가 발생하지 않는다")
    void playCountValidLimit(String count) {
        assertSimpleTest(() -> {
                    run(count);
                    assertThatCode(() -> playCountController.validatePlayCount())
                            .doesNotThrowAnyException();
                }
        );
    }

    private void throwException(String count) {
        assertSimpleTest(() -> {
            run(count);
            assertThatThrownBy(() -> playCountController.validatePlayCount())
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    protected void runMain() {

    }

}