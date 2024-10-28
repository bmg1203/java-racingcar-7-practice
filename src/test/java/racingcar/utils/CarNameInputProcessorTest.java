package racingcar.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.exception.ExceptionMessage.*;
import static racingcar.utils.CarNameInputProcessor.splitCarNames;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CarNameInputProcessorTest {

    @DisplayName("빈 문자열 또는 공백인 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void testEmptyOrBlankInput(String input) {
        assertThatThrownBy(() -> splitCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_INPUT_ERROR);
    }

    @DisplayName("입력 값의 맨 앞이나 맨 뒤에 쉼표가 오는 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {", pobi, woni", "pobi, woni,"})
    void testInputWithComma(String input) {
        assertThatThrownBy(() -> splitCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_COMMA_POSITION);
    }

    @DisplayName("유효한 자동차 이름 입력 - List 반환(중복 Ok)")
    @ParameterizedTest
    @MethodSource("provideValidCarName")
    void testValidCarName(String input, List<String> expected) {
        List<String> result = splitCarNames(input);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideValidCarName() {
        return Stream.of(
                Arguments.of("pobi,woni,jun", List.of("pobi", "woni", "jun")),
                Arguments.of("pobi , woni , jun", List.of("pobi", "woni", "jun")),
                Arguments.of("pobi , woni , woni", List.of("pobi", "woni", "woni")),
                Arguments.of("pobi", List.of("pobi")),
                Arguments.of("pobi,   jun", List.of("pobi", "jun")),
                Arguments.of("ca po,  ca jn", List.of("ca po", "ca jn"))
        );
    }
}
