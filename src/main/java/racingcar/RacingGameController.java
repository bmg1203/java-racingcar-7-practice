package racingcar;

import java.util.List;

public class RacingGameController {
    private final RacingGame racingGame;

    public RacingGameController(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public String run(List<Car> cars, String round) {
        List<String> winner = racingGame.play(cars, getRound(round));
        return formatWinner(winner);
    }

    private int getRound(String input) {
        int round;
        try {
            round = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

        if (round < 1) {
            throw new IllegalArgumentException("1이상의 숫자를 입력해주세요");
        }
        return round;
    }

    private String formatWinner(List<String> winner) {
        return String.join(",", winner);
    }
}
