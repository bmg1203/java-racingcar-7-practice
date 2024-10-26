package racingcar.racingGame;

import racingcar.car.Car;
import racingcar.car.CarImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.exception.ExceptionMessage.CAR_NAME_NOT_DUPLICATION;
import static racingcar.utils.InputSplitter.inputSplit;

public class RacingGameImpl implements RacingGame{
    private final List<Car> racingCars = new ArrayList<>();

    public RacingGameImpl(String inputRacingCarsName) {
        List<String> carsName = inputSplit(inputRacingCarsName);

        for (String carName : carsName) {
            checkDuplicationCarName(carName);
            racingCars.add(new CarImpl(carName));
        }
    }

    @Override
    public List<Car> moveRacingCars(List<Integer> randomNumbers) {
        IntStream.range(0, racingCars.size())
                .forEach(i -> racingCars.get(i).move(randomNumbers.get(i)));
        return List.copyOf(racingCars);
    }

    @Override
    public List<Car> getWinners() {
        int firstPosition = getFirstPosition();

        List<Car> winners = racingCars.stream()
                .filter(car -> car.getPosition() == firstPosition)
                .collect(Collectors.toList());

        return winners;
    }

    @Override
    public int getNumberOfRacingCars() {
        return racingCars.size();
    }

    private int getFirstPosition() {
        Optional<Car> frontCar = racingCars.stream()
                .max(Comparator.comparingInt(Car::getPosition));

        return frontCar.map(Car::getPosition).orElse(0);
    }

    private void checkDuplicationCarName(String carName) {
        boolean isDuplicate = racingCars.stream()
                .anyMatch(racingCar -> racingCar.getCarName().equals(carName));

        if (isDuplicate) {
            throw new IllegalArgumentException(CAR_NAME_NOT_DUPLICATION);
        }
    }
}
