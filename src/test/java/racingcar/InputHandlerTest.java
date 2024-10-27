package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputHandlerTest {

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "pobi,woni,jun:pobi, woni, jun",
                    "juhee:juhee",
                    "pobi,woni,jun, car1, car2,  car3, haha, hihi, h ,    ho:pobi, woni, jun, car1, car2, car3, haha, hihi, h, ho",
                    "멋진차, 짱멋진차, 붕붕이12,빠르다빨라:멋진차, 짱멋진차, 붕붕이12, 빠르다빨라"
            },
            delimiter = ':'
    )
    void 자동차_이름_입력_테스트(String input, String expectedNames) {
        // give
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        List<String> carNames = InputHandler.getCarNames();

        // then
        assertThat(carNames).containsExactly(expectedNames.split(", "));
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n", " "})
    void 자동차_이름_입력_예외_테스트_입력없음(String input) {
        // give
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when & then
        assertThatThrownBy(InputHandler::getCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("경주할 자동차 이름을 입력하세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,   , jun", ",", ",,", " ,  ,  ,,"})
    void 자동차_이름_입력_예외_테스트_빈이름(String input) {
        // give
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when & then
        assertThatThrownBy(() -> {
            try {
                InputHandler.getCarNames();
            } catch (final NoSuchElementException ignore) {
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("쉼표 사이에 이름이 작성되어야 합니다.");
    }


    @ParameterizedTest
    @ValueSource(strings = {"abcdefg", "fobi, 붕붕이123"})
    void 자동차_이름_입력_예외_테스트_긴이름(String input) {
        // give
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when & then
        assertThatThrownBy(InputHandler::getCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("이름은 5글자 이하로 작성 가능합니다.");
    }
}