package racingcar.util.formatter;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class PrintFormatter {
    public String formatRoundResult(Car car) {
        return car.getName() + " : " + car.getCurrentDistance();
    }

    public String formatWinner(final String prefix, List<Car> cars) {
        return prefix + cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
