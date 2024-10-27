package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ResultView {
    private static final String PRINT_RACE_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String PRINT_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final String PRINT_RESULT_MESSAGE = "실행 결과";
    private static final String PRINT_GO_DISTANCE = "-";
    private static final String PRINT_GO_CAR_NAME = "%s : ";

    public static void printRaceCarName() {
        System.out.println(PRINT_RACE_CAR_NAME);
    }

    public static void printTryCount() {
        System.out.println(PRINT_TRY_COUNT);
    }

    public static void printResultMessage() {
        System.out.println(PRINT_RESULT_MESSAGE);
    }

    public static void printGoDistance(Cars cars) {
        for (Car car : cars.getCars()) {
            printCarName(car.getCarName());
            System.out.println(PRINT_GO_DISTANCE.repeat(car.getDistanceValue()));
        }
        System.out.println();
    }

    public static void printCarName(String carName) {
        System.out.printf(PRINT_GO_CAR_NAME, carName);
    }


    public static void printWinnerCarName(List<String> winnerNames) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
