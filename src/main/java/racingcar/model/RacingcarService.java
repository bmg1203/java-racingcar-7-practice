package racingcar.model;

import static racingcar.exception.InvalidInputException.validateCarNames;
import static racingcar.util.Parsing.convertStringArrToMap;
import static racingcar.util.Parsing.joinWinner;
import static racingcar.util.Parsing.splitCarName;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import racingcar.view.OutputView;

public class RacingcarService {
    private final OutputView outputView;
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int STANDARD_NUMBER = 4;

    public RacingcarService() {
        outputView = OutputView.getInstance();
    }

    public void runRace(String carName, int attemptCount) {
        Racingcar racingcar = new Racingcar(carName);
        String[] carNames = splitCarName(racingcar.getCarName());
        validateCarNames(carNames);
        Map<String, String> player = convertStringArrToMap(carNames);
        startRace(player, attemptCount);
        List<String> winner = pickWinner(player, getMaxDashLength(player));
        outputView.winner(joinWinner(winner));
    }

    private void startRace(Map<String, String> player, int attemptCount) {
        outputView.runResult();
        for (int i = 0; i < attemptCount; i++) {
            movingForward(player);
            printRoundResult(player);
        }
    }

    private void movingForward(Map<String, String> player) {
        for (String key : player.keySet()) {
            if (Randoms.pickNumberInRange(START_NUMBER, END_NUMBER) > STANDARD_NUMBER) {
                player.put(key, player.get(key) + "-");
            }
        }
    }

    private void printRoundResult(Map<String, String> player) {
        for (Map.Entry<String, String> entry : player.entrySet()) {
            outputView.roundResult(entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    private int getMaxDashLength(Map<String, String> player) {
        int max = 0;
        for (Map.Entry<String, String> entry : player.entrySet()) {
            max = Math.max(entry.getValue().length(), max);
        }
        return max;
    }

    private List<String> pickWinner(Map<String, String> player, int max) {
        List<String> winner = new LinkedList<>();
        for (Map.Entry<String, String> entry : player.entrySet()) {
            if (entry.getValue().length() == max) {
                winner.add(entry.getKey());
            }
        }
        return winner;
    }
}
