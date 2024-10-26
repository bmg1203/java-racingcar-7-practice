package racingcar.io;

import java.util.List;

public class RacingCarIOHandler {
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public List<String> askCarNames() {
        outputHandler.showCarNameInputMessage();
        return inputHandler.getCarNames();
    }

    public int askRound() {
        outputHandler.showRoundInputMessage();
        return inputHandler.getRound();
    }

    public void showGameResult(String gameResult) {
        outputHandler.showGameResult(gameResult);
    }

}
