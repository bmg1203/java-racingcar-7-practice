package racingcar.persistence;

import java.util.List;
import racingcar.domain.CarRacer;

public interface CarRacerRepository {

    List<CarRacer> getAll();

    void addAll(List<CarRacer> carRacers);

    void clear();
}
