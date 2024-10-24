package racingcar;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import racingcar.domain.RacingCars;
import racingcar.domain.Winning;
import racingcar.exception.EmptyNameBetweenCommaException;
import racingcar.exception.SingleCarNameException;
import racingcar.exception.TryCountException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final String DELIMITER = ",";
        final int MIN_TRY_COUNT = 1;
        final int MAX_TRY_COUNT = 100; // 수정 가능

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 자동차 이름 입력받기
        String inputCarsName = inputView.readCarsName();

        // validator에 추가
        if (!inputCarsName.contains(DELIMITER)) {
            throw new SingleCarNameException();
        }

        String[] splitCarName = Arrays.stream(inputCarsName.split(DELIMITER, -1))
                .map(String::trim)
                .toArray(String[]::new);

        // validator에 추가
        for (String carName : splitCarName) {
            if (carName.isEmpty()) {
                throw new EmptyNameBetweenCommaException();
            }
        }

        // 시도 횟수 입력받기
        int inputCount = inputView.readTryCount();

        // validator에 추가
        if (inputCount < MIN_TRY_COUNT || inputCount > MAX_TRY_COUNT) {
            throw new TryCountException();
        }

        // 게임 시작
        RacingCars racingCars = new RacingCars();
        Map<String, Integer> cars = racingCars.initializeCars(splitCarName);

        for (int count = 0; count < inputCount; count++) {
            racingCars.race();
            outputView.printOneRoundResult(cars);
        }

        Winning winning = new Winning();
        winning.calculateWinningScore(cars);
        Set<String> winningCars = winning.getWinningCars(cars);
        outputView.printWinningCars(winningCars);

    }
}