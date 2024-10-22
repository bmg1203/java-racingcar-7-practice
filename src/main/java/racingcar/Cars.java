package racingcar;

import static racingcar.CompeteResult.DRAW;
import static racingcar.CompeteResult.WIN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String... carNames) {
        this(Arrays.stream(carNames)
                .map(Car::new)
                .toList());
    }

    public Cars(List<Car> cars) {
        validateParticipantsCount(cars);
        this.cars.clear();
        this.cars.addAll(cars);
    }

    private void validateParticipantsCount(List<Car> cars) {
        if (cars.isEmpty() || cars.size() > 1000) {
            throw new IllegalArgumentException("자동차 경주 게임에 참여하는 자동차는 1대 이상, 1000 대 이하여야 합니다.");
        }
    }

    public void ongoingAllCars(OngoingValueGenerator onGoingValueGenerator) {
        for (Car car : this.cars) {
            car.ongoing(onGoingValueGenerator.generate());
        }
    }

    public List<Car> getLeadingCars() {
        List<Car> leadingCars = new ArrayList<>();
        Car leadingCar = cars.getFirst();
        for (Car car : cars) {
            if (car.compete(leadingCar) == WIN) {
                leadingCar = car;
            }
        }
        for (Car car : cars) {
            if (car.compete(leadingCar) == DRAW) {
                leadingCars.add(car);
            }
        }
        return leadingCars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
