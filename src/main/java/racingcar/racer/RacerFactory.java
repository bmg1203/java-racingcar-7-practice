package racingcar.racer;

import java.util.List;

public interface RacerFactory<T> {
    public abstract List<T> createRacers();
}