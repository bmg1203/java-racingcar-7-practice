package racingcar;

import racingcar.stadium.CarRegisterManager;
import racingcar.car.Cars;
import racingcar.stadium.Track;
import racingcar.stadium.Racing;
import racingcar.console.InputView;
import racingcar.console.OutputView;

public class GamePack {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CarRegisterManager carRegisterManager = new CarRegisterManager();

    public void play() {
        Racing racing = initRacing();
        Track track = initTrack();

        startRacing(track, racing);
        endRacing(racing);
    }

    public Racing initRacing() {
        String names = inputView.inputCarNames();
        Cars cars = carRegisterManager.register(names);

        return Racing.from(cars);
    }

    public Track initTrack() {
        int lap = inputView.inputLap();

        return Track.from(lap);
    }

    public void startRacing(Track track, Racing racing) {
        outputView.printStartRacing();

        while (track.isLapInProgress()) {
            racing.moveCars();
            track.decrementLap();

            outputView.printRacingStatus(racing);
        }
    }

    public void endRacing(Racing racing) {
        outputView.printRacingWinners(racing);
    }

}
