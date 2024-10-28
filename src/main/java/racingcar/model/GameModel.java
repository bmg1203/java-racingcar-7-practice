package racingcar.model;

public class GameModel {

    private static final RacingGame racingGame = new RacingGame();
    private static final RacingJudge racingJudge = new RacingJudge();
    private static final Generator generator = new Generator();
    private static final InputValidator inputValidator = new InputValidator();

    public RacingGame getRacingGameEngine() {
        return racingGame;
    }

    public RacingJudge getRacingJudge() {
        return racingJudge;
    }

    public Generator getGenerator() {
        return generator;
    }

    public void checkValidNames(String names) {
        inputValidator.checkValidNames(names);
    }

    public void checkValidAttempts(String attempts) {
        inputValidator.checkValidAttempts(attempts);
    }
}
