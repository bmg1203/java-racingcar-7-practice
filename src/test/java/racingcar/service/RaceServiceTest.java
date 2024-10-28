package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.utils.RaceErrorMessage.*;

public class RaceServiceTest {

    private final RaceService raceService = new RaceService();

    @Test
    @DisplayName("시도 횟수가 정상적인 자연수로 반환되는지 테스트")
    void testFindAttemptNumSuccessfully() {
        String inputNum = "5";

        int attemptNum = raceService.findAttemptNum(inputNum);

        assertThat(attemptNum).isEqualTo(5);
    }

    @Test
    @DisplayName("시도 횟수가 비어있을 때 IllegalArgumentException이 발생하는지 테스트")
    void testEmptyAttemptThrowsException() {

        String inputBlank = "";

        assertThatThrownBy(() -> raceService.findAttemptNum(inputBlank))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_ATTEMPT_REQUIRED);
    }

    @Test
    @DisplayName("입력받은 시도횟수가 문자열일 때 IllegalArgumentException이 발생하는지 테스트")
    void testAttemptThrowsExceptionForStringInput() {
        String inputString = "test";

        assertThatThrownBy(() -> raceService.findAttemptNum(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_INVALID_ATTEMPT_FORMAT);
    }

    @Test
    @DisplayName("입력받은 시도횟수가 음수일 때 IllegalArgumentException이 발생하는지 테스트")
    void testAttemptThrowsExceptionForNegativeInput() {
        String inputString = "-2";

        assertThatThrownBy(() -> raceService.findAttemptNum(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NEGATIVE_ATTEMPTS);
    }

    @Test
    @DisplayName("입력받은 시도 횟수가 int 범위를 초과할 때 IllegalArgumentException이 발생하는지 테스트")
    void testAttemptThrowsExceptionForOverflowInput() {
        String inputString = "2147483648";

        assertThatThrownBy(() -> raceService.findAttemptNum(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_INVALID_ATTEMPT_FORMAT);
    }



}
