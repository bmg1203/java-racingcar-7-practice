package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarTest {
    @MethodSource("testData")
    @ParameterizedTest
    void 차_생성_성공(String input, String output) {
        Car car = Car.create(input, 0);
        assertThat(car.getName()).isEqualTo(output);
    }

    @MethodSource("errorTestData")
    @ParameterizedTest
    void 차_생성_실패(String input, Exception e) {
        assertThatThrownBy(() -> Car.create(input, 0)).isInstanceOf(e.getClass());
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.arguments("yiju", "yiju"),
                Arguments.arguments("1", "1"),
                Arguments.arguments("java", "java")
        );
    }

    static Stream<Arguments> errorTestData() {
        return Stream.of(
                Arguments.arguments("cherry", new IllegalArgumentException()),
                Arguments.arguments("", new IllegalArgumentException())
        );
    }
}
