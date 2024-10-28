package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RaceLog;

public interface RaceService {
    void setRaceCars(String input);
    List<RaceLog> executeRaceRounds(int round);
    List<Car> generateWinners();
}
