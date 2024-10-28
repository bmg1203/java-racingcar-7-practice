package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarListTest {

    @Test
    void 자동차_이름_테스트() {
        // Given
        String input = "pobi,woni,java";

        // When
        List<String> result = CarList.carList(input);

        // Then
        assertThat(result).containsExactly("pobi", "woni", "java");
    }

    @Test
    void 자동차_이름_길이_테스트() {
        // Given
        String input = "pobi,woni,javaistoolong";

        // Then
        assertThatThrownBy(() -> CarList.carList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_중복_테스트() {
        // Given
        String input = "pobi,woni,Spini,pobi";

        // Then
        assertThatThrownBy(() -> CarList.carList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_경계_테스트() {
        // Given
        String input = "pobii, wonii ,javai, ja va";

        // When
        List<String> result = CarList.carList(input);

        // Then
        assertThat(result).containsExactly("pobii", "wonii", "javai", "ja va");
    }

    @Test
    void 자동차_이름_공백_테스트() {
        // Given
        String input = "pobi, ,java";

        // Then
        assertThatThrownBy(() -> CarList.carList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백을_포함한_자동차_이름_테스트() {
        // Given
        String input = "  pobi ,   woni ,   java   ";

        // When
        List<String> result = CarList.carList(input);

        // Then
        assertThat(result).containsExactly("pobi", "woni", "java");
    }
}