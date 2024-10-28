package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingCarController;
import racingcar.model.game.strategy.MovingStrategy;
import racingcar.model.game.strategy.RacingCarMovingStrategy;
import racingcar.support.repeater.StringRepeater;
import racingcar.support.comparable.IntegerComparable;
import racingcar.support.comparable.NumberComparable;
import racingcar.support.random.RandomIntegerGenerator;
import racingcar.support.random.RandomNumberGenerator;
import racingcar.support.splitter.Splitter;
import racingcar.view.input.ConsoleInputView;
import racingcar.view.output.ConsoleOutputView;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class Application {

    private static final String DELIMITER = ",";
    private static final int RANDOM_NUMBER_START_INCLUSIVE = 0;
    private static final int RANDOM_NUMBER_END_INCLUSIVE = 9;
    private static final int FORWARD_MIN_INCLUSIVE = 4;
    private static final String HYPHEN = "-";

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        Splitter splitter = new Splitter(DELIMITER);
        RandomNumberGenerator randomNumberGenerator = new RandomIntegerGenerator(RANDOM_NUMBER_START_INCLUSIVE,
                RANDOM_NUMBER_END_INCLUSIVE);
        NumberComparable numberComparable = new IntegerComparable();
        MovingStrategy movingStrategy = new RacingCarMovingStrategy(randomNumberGenerator, numberComparable,
                FORWARD_MIN_INCLUSIVE);
        StringRepeater stringRepeater = new StringRepeater(HYPHEN);

        RacingCarController controller = new RacingCarController(inputView, outputView, splitter, movingStrategy,
                stringRepeater);
        controller.process();
        Console.close();
    }
}
