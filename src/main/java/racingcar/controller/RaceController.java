package racingcar.controller;

import java.util.Optional;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    RaceService raceService;
    InputView inputView;
    OutputView outputView;

    private RaceController(RaceService raceService, InputView inputView, OutputView outputView) {
        this.raceService = raceService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private static class Holder {
        private static RaceController instance;
    }

    public static RaceController getInstance(RaceService raceService, InputView inputView, OutputView outputView) {
        if (Holder.instance == null) {
            Holder.instance = new RaceController(raceService, inputView, outputView);
        }
        return Holder.instance;
    }

    public void run() {
        raceService.setRaceCars(inputView.inputCarNames());
        int tryCount = validateAndParseNumeric(inputView.inputTryCount());
        outputView.printRaceLogs(raceService.executeRaceRounds(tryCount));
        outputView.printRaceWinners(raceService.generateWinners());
    }

    private int validateAndParseNumeric(String stringInput) {
        return Optional.ofNullable(stringInput)
                .map(Integer::parseInt)
                .orElseThrow(IllegalArgumentException::new);
    }
}
