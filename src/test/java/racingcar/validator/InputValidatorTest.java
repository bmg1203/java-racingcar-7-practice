package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Test
    void 중복_이름_예외_테스트() {
        //given
        List<String> names = new ArrayList<>();
        names.add("pobi");
        names.add("woni");
        names.add("pobi");

        //when, then
        assertThatThrownBy(() -> InputValidator.validateDuplicateName(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-", "t", "ㅇ"})
    void 시도회수_예외_테스트(String tryCount) {
        //when, then
        assertThatThrownBy(() -> InputValidator.validateTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}