package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.config.RaceConstants;
import racingcar.model.Car;
import racingcar.model.RaceLog;
import racingcar.repository.CarRepository;
import racingcar.repository.InMemoryCarRepository;

public class RaceServiceImpl implements RaceService{
    private final CarRepository carRepository;

    private RaceServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    private static class Holder {
        private static final RaceServiceImpl INSTANCE = new RaceServiceImpl(InMemoryCarRepository.getInstance());
    }

    public static RaceService getInstance() {
        return Holder.INSTANCE;
    }

    public static RaceService createNewInstance() {
        return new RaceServiceImpl(InMemoryCarRepository.createNewInstance());
    }

    @Override
    public void setRaceCars(String carNameInput) {
        Arrays.stream(carNameInput.split(RaceConstants.NAME_SEPARATOR_REGEX))
                .map(this::validateNameAndCreatCar)
                .forEach(carRepository::save);
    }

    private Car validateNameAndCreatCar(String name) {
        validateCarName(name);
        return new Car(name);
    }

    @Override
    public List<RaceLog> executeRaceRounds(int round) {
        List<Car> cars = carRepository.findAll();

        validateRound(round);

        return IntStream.range(0, round)
                .mapToObj(i -> executeRaceRound(cars))
                .toList();
    }

    private RaceLog executeRaceRound(List<Car> cars) {
        cars.forEach(Car::tryMove);
        return new RaceLog(List.copyOf(cars));
    }

    @Override
    public List<Car> generateWinners() {
        return carRepository.findWinners();
    }

    private void validateCarName(String name) {
        validateNameLength(name);
        validateNameDuplication(name);
        validateNameBlank(name);
    }

    private void validateNameLength(String name) {
        if(name.length() > RaceConstants.CAR_NAME_THRESHOLD) {
            resetRepositoryAndThrowIllegalArgumentException();
        }
    }

    private void validateNameDuplication(String name) {
        if(carRepository.existsByName(name)) {
            resetRepositoryAndThrowIllegalArgumentException();
        }
    }

    private void validateNameBlank(String name) {
        if(name.isBlank()) {
            resetRepositoryAndThrowIllegalArgumentException();
        }
    }

    private void validateRound(int round) {
        validatePositive(round);
        validateTooBig(round);
    }

    private void validatePositive(int round) {
        if (round <= 0) {
            resetRepositoryAndThrowIllegalArgumentException();
        }
    }

    private void validateTooBig(int round) {
        if (round >= RaceConstants.TOO_BIG_NUMBER) {
            resetRepositoryAndThrowIllegalArgumentException();
        }
    }

    private void resetRepositoryAndThrowIllegalArgumentException() {
        carRepository.reset();
        throw new IllegalArgumentException();
    }
}
