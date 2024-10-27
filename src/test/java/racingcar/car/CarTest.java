package racingcar.car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.CarNameException.NameLengthExceededException;
import static racingcar.exception.CarNameException.NameLengthShortException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.player.GamePlayer;


class CarTest {

    @Nested
    @DisplayName("생성 메서드")
    class 생성_메서드 {
        @DisplayName("생성_성공")
        @Test
        void 생성_성공() {
            // given
            final String sufficientLengthName = "kim";

            // expect
            assertThatCode(() -> Car.of(sufficientLengthName))
                    .doesNotThrowAnyException();
        }

        @DisplayName("생성_실패_Null")
        @Test
        void 생성_실패_Null() {
            // given
            final String Null = null;

            // expect
            assertThatThrownBy(() -> GamePlayer.of(Null))
                    .isInstanceOf(NullPointerException.class);
        }

        @DisplayName("생성_실패_이름길이초과")
        @Test
        void 생성_실패_이름길이초과() {
            // given
            final String elevenWords = "123456789**";

            // expect
            final String expectMessage = "자동차 이름은 최대 10자까지 가능합니다.";

            assertThatThrownBy(() -> {
                GamePlayer.of(elevenWords);
            })
                    .isInstanceOf(NameLengthExceededException.class)
                    .hasMessage(expectMessage);
        }

        @DisplayName("생성_실패_이름길이미달")
        @ParameterizedTest
        @ValueSource(strings = {""})
        void 생성_실패_이름길이미달(String inSufficientLengthName) {
            //expect
            final String expectMessage = "자동차 이름은 최소 1자부터 가능합니다.";

            assertThatThrownBy(() -> {
                GamePlayer.of(inSufficientLengthName);
            })
                    .isInstanceOf(NameLengthShortException.class)
                    .hasMessage(expectMessage);
        }

        @DisplayName("생성_성공_유효길이이름")
        @ParameterizedTest
        @ValueSource(strings = {"1", "22", "333", "4444", "55555", "666666", "7777777", "88888888", "!!!!!!!!!",
                "ㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌ"})
        void 생성_성공_유효길이이름(String sufficientLengthName) {
            //expect
            assertThatCode(() -> Car.of(sufficientLengthName))
                    .doesNotThrowAnyException();
            ;
        }
    }

    @Nested
    @DisplayName("전진 메서드")
    class 전진_메서드 {

        @DisplayName("전진_성공")
        @Test
        void 전진_성공() {
            // given
            final String carName = "carName";
            final int amount = 5;
            Car car = Car.of(carName);
            Distance distance = Distance.of(amount);

            //expect
            assertThatCode(() -> car.move(distance)).doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("거리같음여부 메서드")
    class 거리같음여부_메서드 {
        @DisplayName("참_거리같음판별")
        @Test
        void 거리같음판별_참() {
            // given
            final String carName = "carName";
            final int expectDistance = 0;
            Car car = Car.of(carName);

            // when
            boolean result = car.hasSamePosition(expectDistance);

            // then
            final boolean True = true;
            Assertions.assertEquals(result, True);

        }

        @DisplayName("참_거리같음판별")
        @ParameterizedTest
        @ValueSource(ints = {-1, 1, 2, 3, 4, 5, 100})
        void 거리같음판별_거짓(int unexpectDistance) {
            // given
            final String carName = "carName";
            Car car = Car.of(carName);

            // when
            boolean result = car.hasSamePosition(unexpectDistance);

            // then
            final boolean False = false;
            Assertions.assertEquals(result, False);

        }
    }
}