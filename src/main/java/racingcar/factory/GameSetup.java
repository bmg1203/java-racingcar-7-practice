package racingcar.factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarGroup;
import racingcar.domain.game.Round;

public abstract class GameSetup {

    public static CarGroup createCars(String carNames) {
        List<Car> carList = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
        return new CarGroup(carList);
    }

    public static Round setRound(String roundInput) {
        return new Round(roundInput);
    }
}
