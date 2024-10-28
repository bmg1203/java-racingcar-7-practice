package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerCalculator {

    private WinnerCalculator() {
    }

    public static List<String> calculateWinners(Cars cars) {
        List<String> winnerNames = new ArrayList<>();
        for (Car currentCar : cars.getCars()) {
            compareOtherCars(cars.getCars(), currentCar);
            addIfWinner(cars.getCars(), winnerNames, currentCar);
        }

        return winnerNames;
    }

    private static boolean compareOtherCars(List<Car> lastRacingRecord, Car currentCar) {
        for (Car otherCar : lastRacingRecord) {
            boolean isNotWinner = currentCar != otherCar && !(currentCar.isAheadOrEqual(otherCar));
            if (isNotWinner) {
                return false;
            }
        }

        return true;
    }

    private static void addIfWinner(List<Car> lastRacingRecord, List<String> winnerNames, Car currentCar) {
        if (compareOtherCars(lastRacingRecord, currentCar)) {
            winnerNames.add(currentCar.getCarName().getCarName());
        }
    }
}
