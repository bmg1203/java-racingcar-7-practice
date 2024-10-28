package racingcar.entity;

import java.util.List;
import racingcar.Config;
import racingcar.exception.ExceptionUtils;
import racingcar.exception.RaceValidationError;
import racingcar.util.RandomNumberGenerator;

public class Race {
    final List<Car> cars;

    private Race() {
        this.cars = null;
    }

    public Race(List<Car> cars) {
        this.cars = cars;
        validate(cars);
    }

    public void runSingleRound(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : this.cars) {
            car.move(randomNumberGenerator.pickRandomNumberInRange(Config.RANDOM_NUMBER_BEGIN.getValue(),
                    Config.RANDOM_NUMBER_END.getValue()));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<String> getWinners() {
        int maxPosition = this.cars
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalStateException::new);

        return this.cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public List<String> getCarNames() {
        return this.cars.stream().map(Car::getName).toList();
    }

    private void validate(List<Car> cars) {
        if (cars == null) {
            ExceptionUtils.throwIllegalArgException(RaceValidationError.CARS_NULL);
        } else if (Config.NUMBER_OF_CAR_LIMIT.getValue() < cars.size()) {
            ExceptionUtils.throwIllegalArgException(RaceValidationError.CARS_EXCEED_LIMIT);
        } else if (cars.stream().map(Car::getName).distinct().count() != cars.size()) {
            ExceptionUtils.throwIllegalArgException(RaceValidationError.CARS_DUPLICATE_NAME);
        }
    }
}
