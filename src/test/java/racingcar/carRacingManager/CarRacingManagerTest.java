package racingcar.carRacingManager;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domian.car.Car;
import racingcar.repository.CarRepository;

class CarRacingManagerTest {

    CarRepository carRepository;
    CarRacingManager carRacingManager;
    Car car1;
    Car car2;
    Car car3;
    Car car4;

    @BeforeEach
    void beforEach() {
        carRepository = new CarRepository();
        carRacingManager = new CarRacingManager(carRepository);
        car1 = Car.createCar("name1");
        car2 = Car.createCar("name2");
        car3 = Car.createCar("name3");
        car4 = Car.createCar("name4");

        carRepository.saveCarRepository(car1);
        carRepository.saveCarRepository(car2);
        car2.forward();
        carRepository.saveCarRepository(car3);
        car3.forward();
        car3.forward();
        car3.forward();
        carRepository.saveCarRepository(car4);
        car4.forward();
        car4.forward();
        car4.forward();
    }

    @Test
    void 승자가_한명일_경우() {
        List<Car> winners = carRacingManager.checkWhoIsWinner();
        Assertions.assertEquals(car3.getCarName(), winners.get(0).getCarName());
        Assertions.assertEquals(car4.getCarName(), winners.get(1).getCarName());

    }


}