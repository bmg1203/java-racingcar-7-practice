package racingcar.initialTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinnersTest {
    Winners winners;
    Car car1;
    Car car2;
    Car car3;
    Car car4;
    Car car5;
    Car car55;
    Car car555;
    CarRepository carRepository;
    List<Car> expectedCars;
    List<Car> expectedWinnersList;

    @BeforeEach
    void beforeEach() {
        carRepository = new CarRepository();
        winners = new Winners();
        car1 = new Car("car1", 1);
        car2 = new Car("car2", 2);
        car3 = new Car("car3", 3);
        car4 = new Car("car4", 4);
        car5 = new Car("car5", 5);
        car55 = new Car("car55", 5);
        car555 = new Car("car555", 5);
        carRepository.saveCarRepository(car1);
        carRepository.saveCarRepository(car2);
        carRepository.saveCarRepository(car3);
        carRepository.saveCarRepository(car4);
        carRepository.saveCarRepository(car5);
        carRepository.saveCarRepository(car55);
        carRepository.saveCarRepository(car555);
        expectedCars = List.of(car5, car55, car555, car4, car3, car2, car1);
        expectedWinnersList = List.of(car5, car55, car555);
    }

    @Test
    void compareTest_주행거리가_가장많은순_정렬() {
        List<Car> cars = carRepository.findAll();
        Collections.sort(cars);
        Assertions.assertEquals(cars, expectedCars);
    }

    @Test
    void checkWinnersTest() {
        Car firstCar = expectedCars.get(0);
        int winnerPosition = firstCar.getPosition();
        for (Car expectedCar : expectedCars) {
            if (expectedCar.getPosition() == winnerPosition) {
                winners.addWinners(expectedCar);
            }
        }
        List<Car> winnersList = winners.findWinners();
        Assertions.assertEquals(winnersList, expectedWinnersList);

    }


}

class CarRepository {
    private final List<Car> carRepository = new ArrayList<>();

    public void saveCarRepository(Car car) {
        carRepository.add(car);
    }

    public List<Car> findAll() {
        return new ArrayList<>(carRepository);
    }

}


class Car implements Comparable<Car> {
    private String carName;
    private int position;

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.getPosition(), this.getPosition());
    }

    public int getPosition() {
        return position;
    }


}


class Winners {

    private final List<Car> winners = new ArrayList<>();

    public List<Car> findWinners() {
        return new ArrayList<>(winners);
    }

    public Winners() {
    }


    public void addWinners(Car car) {
        winners.add(car);
    }


}
