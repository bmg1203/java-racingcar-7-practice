package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @Test
    void 자동차_이름_입력시_빈_문자열_검증() {
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.validateCarNamesInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 비어있을 수 없습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {",one,two", "one,two,"})
    void 자동차_이름_입력시_구분자_위치_검증(String testStr) {
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.validateCarNamesInput(testStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자는 차 이름 사이에 위치할 수 있습니다.");
    }

    @Test
    void 자동차_이름_기준_검증() {
        Validator validator = new Validator();

        List<String> testEmptyStr = new ArrayList<>(List.of(""));
        List<String> testLongStr = new ArrayList<>(List.of("onetwo"));

        assertThatThrownBy(() -> validator.validateCarNamesLength(testEmptyStr, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있지 않습니다.");

        assertThatThrownBy(() -> validator.validateCarNamesLength(testLongStr, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 기준을 넘길 수 없습니다.");
    }

    @Test
    void 반복_횟수_입력_검증() {
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.validateRepeatCount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("반복 횟수는 비어있을 수 없습니다.");

        assertThatThrownBy(() -> validator.validateRepeatCount("-123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수만 입력 가능합니다.");

        assertThatThrownBy(() -> validator.validateRepeatCount("123abc456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }
}