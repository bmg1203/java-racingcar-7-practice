package racingcar.repository;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domian.car.Car;

class CarRepositoryTest {
    CarRepository carRepository;
    Car car1;
    Car car2;
    Car car3;
    Car car4;
    Car car44;
    Car car444;

    @BeforeEach
    void beforEach() {
        carRepository = new CarRepository();
        car1 = Car.createCar("name1");
        car2 = Car.createCar("name2");
        car3 = Car.createCar("name3");
        car4 = Car.createCar("name4");
        car44 = Car.createCar("name4");
        car444 = Car.createCar("name4");
    }

    @Test
    void saveCarRepository() {
        carRepository.saveCarRepository(car1);
        carRepository.saveCarRepository(car2);
        carRepository.saveCarRepository(car3);
        carRepository.saveCarRepository(car4);
        List<Car> cars = carRepository.findAll();
        for (int i = 0; i < cars.size(); i++) {
            Assertions.assertEquals("name" + (i + 1), cars.get(i).getCarName());
        }
    }

    @Test
    void validateDuplicate() {
        carRepository.saveCarRepository(car4);
        Assertions.assertThrows(IllegalArgumentException.class, () -> carRepository.saveCarRepository(car44));
    }
}