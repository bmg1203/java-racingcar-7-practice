package racingcar.service;

import java.util.List;
import racingcar.dto.CarDto;

public interface Service {


    void saveCars(String[] carNames);

    void play(String inputTryNumber);

    List<CarDto> whoIsWinner();
}