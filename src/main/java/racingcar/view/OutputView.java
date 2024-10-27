package racingcar.view;

import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.RacingGame;

public class OutputView {

    private static final String HEADER = "\n실행 결과\n";
    private static final String PLAYER_POSITION_TEMPLATE = "%s : %s\n";
    private static final String FOOTER = "\n";
    private static final String ONE_STEP = "-";

    public void printRoundResults(RacingGame racingGame) {
        if (racingGame.isFirstRound()) {
            System.out.printf(HEADER);
        }

        List<RacingCar> players = racingGame.getPlayers();
        for (RacingCar player : players) {
            System.out.printf(PLAYER_POSITION_TEMPLATE, player.getName(), printPosition(player.getPosition()));
        }

        System.out.printf(FOOTER);
    }

    private String printPosition(int position) {
        return ONE_STEP.repeat(position);
    }
}
