package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.utils.StringSplitter;

public class RacingConfig {
    private final String rawUserInput;
    private final String rawTryCount;

    public RacingConfig(String rawUserInput, String rawTryCount) {
        this.rawUserInput = rawUserInput;
        this.rawTryCount = rawTryCount;
    }

    public RacingGame readyRacingGame() {
        List<String> splittedCarsName = StringSplitter.splitByDelimiter(rawUserInput);
        List<CarName> rawCarNames = splittedCarsName.stream()
                .map(CarName::new)
                .toList();

        List<Car> rawCars = rawCarNames.stream().
                map(Car::new)
                .toList();

        return new RacingGame(new Cars(rawCars), new TryCount(rawTryCount));
    }
}

