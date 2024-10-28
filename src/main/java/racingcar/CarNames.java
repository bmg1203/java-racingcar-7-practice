package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarNames {
    private static final String CUSTOM_DELIMITER = ",";
    private final List<CarName> carNames;

    public CarNames(String carName) {
        this.carNames = createCarNames(carName);
    }

    private List<CarName> createCarNames(String carName) {
        return Arrays.stream(carName.split(CUSTOM_DELIMITER))
                .map(CarName::new)
                .toList();
    }

    public List<CarName> getCarNames() {
        return carNames;
    }
}
