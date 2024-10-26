package racingcar.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.exception.Validator;

public class RacingService {
    private final List<Car> carList = new ArrayList<>();
    private final HashMap<Car, Long> carToRacingProgress = new HashMap<>();

    public RacingService(List<String> carNameList) {
        for (String carName : carNameList) {
            Car car = new Car(carName);
            carList.add(car);
            carToRacingProgress.put(car, 0L);
        }
    }

    public void moveForward() {
        for (Car car : carList) {
            car.setRandomNumber();

            if (Validator.isFourOrMore(car.getRandomNumber())) {
                carToRacingProgress.put(car, carToRacingProgress.get(car) + 1);
            }
        }
    }

    public List<String> getWinner() {
        long maxProgress = carToRacingProgress.values()
                .stream()
                .max(Long::compare)
                .orElse(0L);

        return carToRacingProgress.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxProgress)
                .map(entry -> entry.getKey().getName())
                .collect(Collectors.toList());
    }

    public HashMap<Car, Long> getCarToRacingProgress() {
        return carToRacingProgress;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
