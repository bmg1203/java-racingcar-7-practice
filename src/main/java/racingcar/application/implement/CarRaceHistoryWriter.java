package racingcar.application.implement;

import static racingcar.common.constant.FormatConstants.LINE_BREAKER;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.CarRacer;

public class CarRaceHistoryWriter {

    public String writeAll(List<CarRacer> carRacers) {
        return carRacers.stream()
                .map(CarRacer::toString)
                .collect(Collectors.joining(LINE_BREAKER));
    }
}
