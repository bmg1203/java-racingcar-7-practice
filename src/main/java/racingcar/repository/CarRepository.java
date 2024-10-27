package racingcar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domian.car.Car;

public class CarRepository {
    private final List<Car> carRepository = new ArrayList<>();
    private final Map<String, Boolean> carNameMap = new HashMap<>();

    public void saveCarRepository(Car car) {
        ValidateDuplicate(car);
        carRepository.add(car);
    }

    public List<Car> findAll() {
        return new ArrayList<>(carRepository);
    }

    public void ValidateDuplicate(Car car) {
        if (carNameMap.containsKey(car.getCarName())) {
            throw new IllegalArgumentException("차 이름은 중복 될 수 없습니다.");
        }
        carNameMap.put(car.getCarName(), true);
    }

   
}
