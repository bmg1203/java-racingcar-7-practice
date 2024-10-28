package racingcar.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.stream.Collectors;
import racingcar.constants.ErrorMessage;

public class CarScores {
    private static final String CARS_SEPARATOR = ",";

    private final LinkedHashMap<CarName, Distance> carScores;

    public CarScores(String cars) {
        isBlank(cars);
        carScores = new LinkedHashMap<>(
                Arrays.stream(cars.split(CARS_SEPARATOR))
                        .map(String::strip)
                        .collect(Collectors.toMap(
                                CarName::new, element -> new Distance(0),
                                (existing, replacement) -> replacement, LinkedHashMap::new)));
    }

    public CarScores(LinkedHashMap<CarName, Distance> carScores) {
        this.carScores = carScores;
    }

    public static void isBlank(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_CAN_NOT_BE_EMPTY.getErrorMessage());
        }
    }

    public LinkedHashMap<CarName, Distance> getCarScores() {
        return carScores;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CarScores comparingCarScores = (CarScores) obj;
        return carScores == comparingCarScores.carScores;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carScores);
    }
}
