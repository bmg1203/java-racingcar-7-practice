package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {

    private void command(String... args) {
        String input = String.join(",", args);
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @AfterEach
    void tearDown() {
        Console.close(); // 각 테스트 이후 Scanner 초기화
    }

    @ParameterizedTest
    @CsvSource({
            "'car,hi,asdf,lll'",
            "'abc,a,b,c'",
            "'aaaa,abcd,abcd,kore,asdf'",
            "'abcde,qwert,qewss,poiuy'"
    })
    void testGetCarNames(String input) {
        // Given
        this.command(input);
        String[] expectedCarNames = input.split(",");

        // When
        List<String> carNames = InputView.getCarNames();

        // Then
        assertThat(carNames).containsExactly(expectedCarNames);
        assertThat(carNames).hasSize(expectedCarNames.length);
    }

    @ParameterizedTest
    @CsvSource({
            "'abc,123,kkk'",        // 이름 아닌 숫자 구성 예외 케이스
            "'abcde,qwerty,pokk'",  // 이름 5글자 초과 예외 케이스
            "'a, b, c'",            // 공백 포함 예외 케이스
            "'a , b'"
    })
    void testGetCarNamesException(String input) {
        // Given
        this.command(input);

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                InputView::getCarNames);
        assertThat(exception.getMessage()).isEqualTo("자동차 이름 입력이 올바르지 않습니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "100",
            "425"
    })
    void testGetMoveCount(String moveCount) {
        // Given
        this.command(moveCount);

        // When
        int moveCountResult = InputView.getMoveCount();

        // Then
        assertThat(moveCountResult).isEqualTo(moveCount);
    }
}