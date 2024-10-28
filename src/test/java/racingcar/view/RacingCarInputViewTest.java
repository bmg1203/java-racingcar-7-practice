package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.DuplicatedCarNameException;
import racingcar.exception.NonParsableIntegerException;
import racingcar.exception.NonPositiveTryCountException;

class RacingCarInputViewTest extends InputTest {

    @Test
    @DisplayName("inputCarNames는 입력에 맞는 자동차 이름 리스트를 정상적으로 반환한다.")
    void inputCarNames_ReturnCorrectly() {
        // given
        presetInput("a,bbb,ccccc");

        // when
        List<String> carNames = RacingCarInputView.inputCarNames();

        // then
        assertThat(carNames)
                .hasSize(3)
                .contains(
                        "a",
                        "bbb",
                        "ccccc"
                );
    }

    @Test
    @DisplayName("inputTryCount는 입력 스트링을 int 값으로 변환하여 반환한다.")
    void inputTryCount_ReturnCorrectly() {
        // given
        presetInput("5");

        // when
        int tryCount = RacingCarInputView.inputTryCount();

        // then
        assertThat(tryCount)
                .isEqualTo(5);
    }

    @Test
    @DisplayName("inputCarNames는 중복된 이름이 있는 입력에 대해 DuplicatedCarNameException을 던진다.")
    void inputCarNames_WhenInputDuplicatedName_ThrowDuplicatedCarNameException() {
        // given
        presetInput("a,bbb,ccccc,bbb");

        // when & then
        assertThatThrownBy(
                RacingCarInputView::inputCarNames
        ).isInstanceOf(DuplicatedCarNameException.class);
    }

    @Test
    @DisplayName("inputTryCount는 Integer형으로 변환할 수 없는 수를 입력하면 NonParsableIntegerException을 던진다.")
    void inputTryCount_WhenInputCantParseInteger_ThrowNonParsableIntegerException() {
        // given
        presetInput("a");

        // when & then
        assertThatThrownBy(
                RacingCarInputView::inputTryCount
        ).isInstanceOf(NonParsableIntegerException.class);
    }

    @Test
    @DisplayName("inputTryCount는 Integer 범위를 벗어난 수를 입력하면 NonParsableIntegerException을 던진다.")
    void inputTryCount_WhenInputCantParseNumber_ThrowNonParsableIntegerException() {
        // given
        presetInput("2147483648");

        // when & then
        assertThatThrownBy(
                RacingCarInputView::inputTryCount
        ).isInstanceOf(NonParsableIntegerException.class);
    }

    @Test
    @DisplayName("inputTryCount는 0 이하의 수를 입력하면 NonPositiveTryCountException을 던진다.")
    void inputTryCount_WhenInputBelow0_ThrowNonPositiveTryCountException() {
        // given
        presetInput("0");

        // when & then
        assertThatThrownBy(
                RacingCarInputView::inputTryCount
        ).isInstanceOf(NonPositiveTryCountException.class);
    }
}
