package racingcar.service;

import java.util.List;
import racingcar.domian.car.Car;

public interface Service {


    void saveCars(String[] carNames);

    void play(String inputTryNumber);

    List<Car> whoIsWinner();
}