package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    public static final String REQUEST_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String REQUEST_FOR_RACE_COUNT = "시도할 횟수는 몇 회인가요?";
    public static final String RACE_RESULT = "실행 결과";
    public static final String FINAL_WINNER_IS = "최종 우승자 : ";

    private OutputView() {}

    public static void requestForCarNames() {
        OutputWriter.displayMessage(REQUEST_FOR_CAR_NAMES);
    }

    public static void requestForRaceCount() {
        OutputWriter.displayMessage(REQUEST_FOR_RACE_COUNT);
    }

    public static void displayRaceResult() {
        OutputWriter.displayNewLine();
        OutputWriter.displayMessage(RACE_RESULT);
    }

    public static void displayRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            OutputWriter.displayMessage(car.getRoundResult());
        }
        OutputWriter.displayNewLine();
    }

    public static void displayWinner(Cars cars) {
        OutputWriter.displayMessage(FINAL_WINNER_IS + cars.getWinnersName());
    }
}