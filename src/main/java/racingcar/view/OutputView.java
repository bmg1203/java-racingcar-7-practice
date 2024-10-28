package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String RACE_START_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printStartGame() {
        System.out.println(RACE_START_MESSAGE);
    }

    public static void printCarPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE + String.join(",", winners));
    }
}
