package racingcar.Controller;

import racingcar.Service.RaceProcessService;

public class RaceProcessController {
    private final RaceViewController raceViewController;
    private final RaceProcessService raceProcessService;

    public RaceProcessController(RaceViewController raceViewController, RaceProcessService raceProcessService) {
        this.raceViewController = raceViewController;
        this.raceProcessService = raceProcessService;
    }
    public void run() {

    }
}
