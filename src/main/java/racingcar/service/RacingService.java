package racingcar.service;

import static racingcar.global.error.Error.NAME_BLANK_EXCEPION;
import static racingcar.global.error.Error.NAME_LENGTH_EXCEPION;
import static racingcar.global.error.Error.TRY_COUNT_EXCEPION;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.global.error.NameError;
import racingcar.global.error.TryCountError;

public class RacingService {

    private final String COMMA = ",";
    private String POSITIVE_NUMBER_REG = "\\d+";

    public List<String> splitCarName(String input) {
        return Arrays.stream(input.split(COMMA)).collect(Collectors.toList());
    }

    public void validateCarName(List<String> carNames) {

        if (!validateNameNotNull(carNames)) {
            throw new NameError(NAME_BLANK_EXCEPION);
        }
        if (!validateNameLength(carNames)) {
            throw new NameError(NAME_LENGTH_EXCEPION);
        }
    }

    public void validateTryCount(String count) {

        if (!validatePositiveIntegerCount(count)) {
            throw new TryCountError(TRY_COUNT_EXCEPION);
        }
    }
    private boolean validateNameNotNull(List<String> carNames) {

        return carNames.stream().allMatch(name -> name != null && !name.isEmpty());
    }

    private boolean validateNameLength(List<String> carNames) {
        return carNames.stream().allMatch(name -> name.length() <= 5);
    }

    private boolean validatePositiveIntegerCount(String count) {
        if (count.matches(POSITIVE_NUMBER_REG)) {
            return Integer.parseInt(count) > 0;
        }
        return false;
    }
}
