package racingcar.controller;

import racingcar.service.RacingcarService;
import racingcar.view.RacingcarView;

public class RacingcarController {

    private RacingcarView racingcarView;
    private RacingcarService racingcarService;
    private final RacingcarView racingcarView;
    private final RacingcarService racingcarService;

    public RacingcarController(RacingcarView racingcarView, RacingcarService racingcarService) {
        this.racingcarView = racingcarView;
        this.racingcarService = racingcarService;
    }

    public void run() {
        
    }
}
