package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    private List<String> carNamesList;
    private int gameRepeats;
    private RacingGame racingGame;

    public void play() {
        getUserInput();
        racingGame = new RacingGame(carNamesList);
        GameValidator.validate(carNamesList, gameRepeats);
        startGame();
        racingGame.printWinners();
    }

    private void getUserInput() {
        carNamesList = User.inputCarNames();
        gameRepeats = User.inputGameRepeats();
        Console.close();
    }

    private void startGame() {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < gameRepeats; i++) {
            racingGame.play();
        }
    }
}
