package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarDto;

public class Winners {

    private final List<CarDto> winners = new ArrayList<>();

    public List<CarDto> findWinners() {
        return new ArrayList<>(winners);
    }

    private Winners() {
    }

    public static Winners createWinners() {
        return new Winners();
    }

    public void addWinners(CarDto carDto) {
        winners.add(carDto);
    }


}
