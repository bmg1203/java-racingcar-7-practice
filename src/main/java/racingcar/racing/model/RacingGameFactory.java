package racingcar.racing.model;

import java.util.List;

public interface RacingGameFactory {
    Game createGame(int allRound);

    List<Car> createCars(List<String> carNames);

    public Winner createWinner(List<Car> cars);
}
