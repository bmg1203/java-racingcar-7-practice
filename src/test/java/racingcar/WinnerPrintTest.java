package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerPrintTest {

    @Test
    void 단독_우승자_테스트() {
        // Given
        Application.nameList = new ArrayList<>(Arrays.asList("pobi", "woni", "java"));
        Application.moveCount = new int[]{3, 5, 2};

        // When
        List<String> winners = WinnerPrint.getWinners();

        // Then
        assertThat(winners).containsExactly("woni");
    }

    @Test
    void 공동_우승자_테스트() {
        // Given
        Application.nameList = new ArrayList<>(Arrays.asList("pobi", "woni", "java"));
        Application.moveCount = new int[]{5, 5, 2};

        // When
        List<String> winners = WinnerPrint.getWinners();

        // Then
        assertThat(winners).containsExactly("pobi", "woni");
    }
}
