package racingcar.services;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.exceptions.ErrorMessages;
import racingcar.models.Cars;

public class CarService {
    private Cars cars;

    public CarService(String carNames) {
        List<String> carNameList = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        this.cars = new Cars(carNameList);
    }

    public void incrementCars() {
        cars.incrementDistance();
    }

    public Map<String, Integer> getCarsInformation() {
        return cars.getInformation();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }

    public int validateAndParseTryCount(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_TRY_COUNT);
        }
    }
}