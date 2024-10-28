package racingcar.racingapp.model.car;

import java.util.Comparator;
import java.util.List;
import racingcar.racingapp.model.value.vo.CarRecord;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("자동차들은 비어있을 수 없습니다.");
        }
        this.cars = List.copyOf(cars);
    }

    public void raceAll() {
        cars.forEach(Car::tryDrive);
    }

    public List<CarRecord> submitRecords() {
        return cars.stream()
                .sorted(Comparator.comparing(Car::getCarName))
                .map(Car::record)
                .toList();
    }

}
