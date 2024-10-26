package racingcar.dto;

import static org.assertj.core.api.Assertions.*;
import static racingcar.common.exception.ErrorMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.exception.RacingCarException;

class RacingCarNamesTest {

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @ParameterizedTest
        @ValueSource(strings = {
                "레드불",
                "페라리,"
        })
        @DisplayName("자동차가 2대 미만일 경우 예외가 발생한다")
        void 자동차가_2대_미만일_경우_예외가_발생한다(String input) {
            assertThatThrownBy(() -> RacingCarNames.from(input))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessage(RACING_CAR_MINIMUM_TWO_REQUIRED.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "페라리,제네nr",
                "max,레드불nr",
        })
        @DisplayName("자동차 이름이 한글 또는 영어로만 이루어지지 않으면 예외가 발생한다.")
        void 자동차_이름이_영어_또는_한글로만_이루어지지_않으면_예외가_발생한다(String input) {
            assertThatThrownBy(() -> RacingCarNames.from(input))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessage(RACING_CAR_NAME_MUST_BE_ENGLISH_OR_KOREAN.getMessage());
        }
    }

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @ParameterizedTest
        @ValueSource(strings = {
                "레드불,페라리",
                "페라리,레드불,벤츠"
        })
        @DisplayName("자동차가 2대 이상일 경우 예외가 발생하지 않는다")
        void 자동차가_2대_이상일_경우_예외가_발생하지_않는다(String input) {
            assertThatCode(() -> RacingCarNames.from(input))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "페라리,멕라렌",
                "Red,Bull",
                "그렌저,제네시스",
                "Audi,Kia",
                "멀세이리,비엠따블류,아우디"
        })
        @DisplayName("자동차 이름이 5글자 이하이며 영어, 한글로만 이루어진 경우 예외가 발생하지 않는다.")
        void 자동차_이름이_5글자_이하의_영어_또는_한글로_이루어진_경우_예외가_발생하지_않는다(String input) {
            assertThatCode(() -> RacingCarNames.from(input))
                    .doesNotThrowAnyException();
        }
    }
}