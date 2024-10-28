package racingcar.Utils;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;


public class InputValidator {

    public static final int CAR_NAME_LIMITS = 5;
    private static final Pattern INVALID_PATTERN = Pattern.compile("[^a-zA-Z0-9]");

    @DisplayName("자동차 이름이 5자 초과 시 예외 발생")
    public static void carNameMoreThan5TextException(String carName) {

        if (carName.trim().length() > CAR_NAME_LIMITS) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + carName);
        }
    }

    @DisplayName("자동차 이름이 문자, 숫자 이외의 것들이 들어갈 시 예외 발생")
    public static void carNameTextAndNumberOtherThanException(String carName) {

        if (INVALID_PATTERN.matcher(carName.trim()).find()) {
            throw new IllegalArgumentException("자동차 이름은 영대소문자와 숫자 밖에 안 됩니다.");
        }
    }

    @DisplayName("문자열이 null 또는 빈 문자열인지 확인하는 메서드")
    public static void validateNotNullOrEmpty(String carName) {

        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않으시면 게임이 시작되지 않습니다.");
        }
    }

    @DisplayName("자동차를 2대 이상 입력했는 지 테스트")
    public static void isAtLeastTwoCars(String[] carNames) {

        if (carNames.length < 2) {
            throw new IllegalArgumentException("자동차를 두 대 이상 입력하셔야 합니다.");
        }
    }

    @DisplayName("자동차 이름 중복 시 예외 발생")
    public static void carNameDuplicatedException(String[] carNames) {

        Set<String> uniqueElements = Arrays.stream(carNames)
                .map(String::trim)
                .collect(Collectors.toSet());

        if (uniqueElements.size() < carNames.length) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }

    @DisplayName("시도할 횟수는 1회부터 20회까지 가능합니다.")
    public static void isValidAttemptCount(int numberOfRounds) {

        if (numberOfRounds < 1 || numberOfRounds > 20) {
            throw new IllegalArgumentException("1회부터 20회까지만 가능합니다.");
        }
    }
}
