package racingcar.model.vo;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("CarName 테스트")
public class CarNameTest {

    @Test
    void 자동차_이름은_5자_이하여야_한다() {
        // given
        String name = "pobiii";

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "pobi ", "12345", "포비", "pobi★"})
    void 자동차의_이름은_영문자열_이어야_한다(String name) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(name));
    }

}
