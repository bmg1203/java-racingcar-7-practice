package racingcar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.car.Car;

public class CarRepository {
    private final List<Car> carRepository = new ArrayList<>();
    private final Map<String, Boolean> carNameMap = new HashMap<>();

    private final static String CAR_DUPLICATED_ERROR = "차 이름은 중복 될 수 없습니다.";

    public void saveCarRepository(Car car) {
        ValidateDuplicate(car);
        carRepository.add(car);
    }

    public List<Car> findAll() {
        return new ArrayList<>(carRepository);
    }

    public void ValidateDuplicate(Car car) {
        String realCarName = car.getCarName();
        String upperRealCarName = realCarName.toUpperCase();
        if (carNameMap.containsKey(upperRealCarName)) {
            throw new IllegalArgumentException(CAR_DUPLICATED_ERROR);
        }
        carNameMap.put(upperRealCarName, true);
    }


}
