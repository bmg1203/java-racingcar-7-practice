package racingcar;

import racingcar.controller.RaceController;

public class Application {
    public static void main(String[] args) {
        final RaceController raceController = new RaceController();
        raceController.execute();
    }
}
