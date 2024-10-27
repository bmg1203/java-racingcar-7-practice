package racingcar.domain.race;


import racingcar.domain.car.Car;
import racingcar.domain.car.CarRegistry;
import racingcar.presentation.CarStatusFormatter;

public class Stadium {
    private final CarRegistry carRegistry;
    private final RaceResult raceResult;
    private final CarStatusFormatter carStatusFormatter;

    private static final String LINE_SEPARATOR = "\n";

    public Stadium(CarRegistry carRegistry, RaceResult result) {
        this.carRegistry = carRegistry;
        this.raceResult = result;
        this.carStatusFormatter = new CarStatusFormatter();
    }

    public void raceEachRounds(Integer rounds) {
        for (int i = 0; i < rounds; i++) {
            executeOneRound();
        }
    }

    private void executeOneRound() {
        for(Car car : carRegistry.getCars()){
            car.moveIfPossible();
        }
        this.raceResult.add(carStatusFormatter.format(carRegistry.getCars())).add(LINE_SEPARATOR);
    }
}
