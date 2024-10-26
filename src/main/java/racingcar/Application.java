package racingcar;

import racingcar.dto.InputDto;
import racingcar.racing.RacingGame;
import racingcar.racing.RacingGameTemplate;
import racingcar.views.InputView;

public class Application {

    public static void main(String[] args) {
        final RacingGameTemplate racingGame = initializeGame();
        racingGame.play();
    }

    private static RacingGameTemplate initializeGame() {
        final InputDto dto = getUserInputToDto();
        return RacingGame.initGame(dto);
    }

    private static InputDto getUserInputToDto() {
        return new InputDto(
                InputView.inputCarNames(),
                InputView.inputRaceAttempts()
        );
    }
}
