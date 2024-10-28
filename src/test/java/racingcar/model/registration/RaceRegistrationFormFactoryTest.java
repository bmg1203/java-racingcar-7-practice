package racingcar.model.registration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.RaceRegistrationForm;

@DisplayName("신청 폼 생성자 테스트")
class RaceRegistrationFormFactoryTest {

    @Test
    @DisplayName("중복되는 자동차 이름이 있는 경우 예외가 발생한다.")
    void should_ThrowException_When_CarNamesDuplicate() {
        String inputCarNames = "pobi,pobi";
        String inputRaceRoundCount = "1";

        assertThatThrownBy(() -> RaceRegistrationFormFactory.create(inputCarNames, inputRaceRoundCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 1자 미만인 경우 예외가 발생한다.")
    void should_ThrowException_When_CarNameLessThan1() {
        String inputCarNames = "";
        String inputRaceRoundCount = "1";
        assertThatThrownBy(() -> RaceRegistrationFormFactory.create(inputCarNames, inputRaceRoundCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 5자를 초과하는 경우 예외가 발생한다.")
    void should_ThrowException_When_CarNameLongerThan5() {
        String inputCarNames = "abcdef";
        String inputRaceRoundCount = "1";
        assertThatThrownBy(() -> RaceRegistrationFormFactory.create(inputCarNames, inputRaceRoundCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름에 공백 문자가 포함된 경우 예외가 발생한다.")
    void should_ThrowException_When_CarNameContainsWhiteSpace() {
        String inputCarNames = "po bi";
        String inputRaceRoundCount = "1";
        assertThatThrownBy(() -> RaceRegistrationFormFactory.create(inputCarNames, inputRaceRoundCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = { "po-bi", "p@bi", "pobi!" })
    @DisplayName("자동차의 이름에 알파벳과 숫자가 아닌 문자가 포함된 경우 예외가 발생한다.")
    void should_ThrowException_When_CarNameContainsInvalidCharacters(String testCarName) {
        String inputRaceRoundCount = "1";
        assertThatThrownBy(() -> RaceRegistrationFormFactory.create(testCarName, inputRaceRoundCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도할 횟수가 1보다 작은 경우 예외 테스트")
    void should_ThrowException_When_RaceRoundCountLessThan1() {
        String inputCarNames = "pobi,woni";
        String inputRaceRoundCount = "0";

        assertThatThrownBy(() -> RaceRegistrationFormFactory.create(inputCarNames, inputRaceRoundCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도할 횟수가 숫자가 아닌 경우 예외 테스트")
    void should_ThrowException_When_RaceRoundCountIsNotNumeric() {
        String inputCarNames = "pobi,woni";
        String inputRaceRoundCount = "가";

        assertThatThrownBy(() -> RaceRegistrationFormFactory.create(inputCarNames, inputRaceRoundCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도할 횟수가 null인 경우 예외 테스트")
    void should_ThrowException_When_RaceRoundCountIsNull() {
        String inputCarNames = "pobi,woni";
        String inputRaceRoundCount = null;

        assertThatThrownBy(() -> RaceRegistrationFormFactory.create(inputCarNames, inputRaceRoundCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 입력인 경우 신청 폼 객체를 반환한다.")
    public void should_ReturnRacingRegisterForm_When_ValidInputGiven() {
        String inputCarNames = "pobi,woni";
        String inputRaceRoundCount = "3";

        RaceRegistrationForm result = RaceRegistrationFormFactory.create(inputCarNames, inputRaceRoundCount);
        assertThat(result).isNotNull();
        assertThat(result.carNames()).containsExactly("pobi", "woni");
        assertThat(result.raceRoundCount()).isEqualTo(3);
    }
}
