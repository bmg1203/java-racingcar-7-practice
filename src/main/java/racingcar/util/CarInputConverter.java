package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.validator.CarNameValidator;

public class CarInputConverter {


    public static List<Car> setCarList(String[] carNames) {

        List<Car> participants = Arrays.stream(carNames)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());

        CarNameValidator.length(participants);
        CarNameValidator.duplicateNames(participants);
        CarNameValidator.emptyOrNullNames(participants);

        return participants;
    }
}
