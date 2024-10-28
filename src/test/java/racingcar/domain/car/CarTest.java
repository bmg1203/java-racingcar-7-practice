package racingcar.domian.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {


    @Test
    void create_Car_And_Check_Name_Test() {
        Car car = Car.createCar("name1");
        Assertions.assertEquals("name1", car.getCarName());
    }


    @Test
    void forward_Test() {
        Car car = Car.createCar("name1");
        car.forward();
        Assertions.assertEquals(1, car.getPosition());
    }


}