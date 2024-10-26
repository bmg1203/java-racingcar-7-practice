package racingcar.controller;

import racingcar.model.RacingCar;

import java.util.List;

public interface OutputController {
    void requestUserCarsInput();
    void requestUserRoundInput();
    void printWinner(List<RacingCar> winners);
}
