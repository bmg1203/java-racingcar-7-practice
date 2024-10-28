package racingcar.controller;

import racingcar.controller.constant.RaceRule;
import racingcar.domain.Race;
import racingcar.domain.Registration;
import racingcar.service.race.RaceStarterService;
import racingcar.service.race.WinnerService;

public class TotalController {
    private static TotalController instance = new TotalController();
    private final RaceStarterService raceStarterService;

    private TotalController() {
        raceStarterService = new RaceStarterService();
    }

    public void init() {
        getInput();
        Race race = openRace();

        connectRelayServer(race);
        prepareRace();

        allLapUpdate(race);
        printWinner(race);
    }

    private void getInput() {
        InputController.getInstance().getInputs();
    }

    private void connectRelayServer(Race race) {
        ScreenController.getInstance().connect(race);
    }

    private Race openRace() {
        Registration registration = RegistrationController.getInstance().register();
        raceStarterService.openRace(registration);
        return raceStarterService.getRace();
    }

    private void prepareRace() {
        RacingController.getInstance().carMovementSetting(raceStarterService);
    }

    private void oneLapUpdate() {
        RacingController.getInstance().gameUpdate();
        ScreenController.getInstance().scoreBoardUpdate();
    }

    private void allLapUpdate(Race race) {
        while (!race.getLapLefts().equals(RaceRule.LAST_LAP.get())) {
            oneLapUpdate();
        }
    }

    private void printWinner(Race race) {
        WinnerService winnerService = new WinnerService(race.getEntry());
        ScreenController.getInstance().printWinner(winnerService.raceWinners());
    }

    public static TotalController getControl() {
        if (instance == null) {
            instance = new TotalController();
        }
        return instance;
    }
}
