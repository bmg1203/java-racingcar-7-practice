package racingcar.util;

import static racingcar.util.constant.CharacterConstant.checkInvalidCharacter;
import static racingcar.util.constant.MoveCarNumberConstant.EXECUTION_RANGE_MAX_VALUE;
import static racingcar.util.constant.MoveCarNumberConstant.EXECUTION_RANGE_MIN_VALUE;
import static racingcar.util.constant.RegisterCarNumberConstant.CAR_NAME_MAX_LENGTH;
import static racingcar.util.constant.RegisterCarNumberConstant.REGISTER_CARS_INPUT_MAX_LENGTH;

import java.util.List;

import racingcar.exception.EmptyInputException;
import racingcar.exception.carName.InvalidCharacterException;
import racingcar.exception.carName.InvalidCarNameLengthException;
import racingcar.exception.carName.InvalidRegisterCarsInputLengthException;
import racingcar.exception.executionNumber.NotNumberException;
import racingcar.exception.executionNumber.NumberRangeException;

public class ValidationUtil {

    public boolean isValidRegisterCarsInputLength(final String input) {
        if(input == null || input.isEmpty()) {
            throw new EmptyInputException();
        }
        if(input.length() > REGISTER_CARS_INPUT_MAX_LENGTH.getValue()) {
            throw new InvalidRegisterCarsInputLengthException();
        }
        return true;
    }

    public boolean isValidCarNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > CAR_NAME_MAX_LENGTH.getValue()) {
                throw new InvalidCarNameLengthException();
            }
            if (carName.isEmpty()) {
                throw new EmptyInputException();
            }
        }
        return true;
    }

    public boolean containsInvalidCharacter(final String value) {
        if (value.chars()
                .anyMatch(character -> checkInvalidCharacter((char) character))) {
            throw new InvalidCharacterException();
        }
        return true;
    }

    public boolean isNumber(final String value) {
        if (value == null || value.isEmpty()) {
            throw new EmptyInputException();
        }

        try {
            Integer.parseInt(value);
            return true;
        } catch(NumberFormatException e) {
            throw new NotNumberException();
        }
    }

    public boolean isValidExecutionRange(final String value) {
        int valueToInt = Integer.parseInt(value);
        if (valueToInt < EXECUTION_RANGE_MIN_VALUE.getValue() ||
                valueToInt > EXECUTION_RANGE_MAX_VALUE.getValue()) {
            throw new NumberRangeException();
        }
        return true;
    }
}
