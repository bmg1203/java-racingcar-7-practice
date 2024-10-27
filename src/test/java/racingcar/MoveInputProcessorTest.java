package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.CarNameInputProcessor;
import racingcar.utils.MoveInputProcessor;

public class MoveInputProcessorTest {

    @DisplayName("입력 값이 빈 문자열 또는 공백인 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void testEmptyOrBlankInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> new MoveInputProcessor(input));
    }


    @DisplayName("입력 값이 0 또는 음수인 경우  - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-2", "-100"})
    void testZeroOrNegativeInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> new MoveInputProcessor(input));
    }


    @DisplayName("입력 값이 문자인 경우  - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {"아이", "2년", "1임"})
    void testStringInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> new MoveInputProcessor(input));
    }


    @DisplayName("입력 값이 유효한 경우 - Integer 반환")
    @ParameterizedTest
    @MethodSource("provideValidCount")
    void testValidCount(String input, int expected) {
        MoveInputProcessor moveInputProcessor = new MoveInputProcessor(input);
        Integer result = moveInputProcessor.getMoveCount();
        assertEquals(expected, result);

    }

    static Stream<Arguments> provideValidCount() {
        return Stream.of(
                Arguments.of("21", 21),
                Arguments.of("1", 1),
                Arguments.of("100", 100)
        );
    }


}
