package racingcar.view;

import java.util.List;
import racingcar.model.CarSnapshot;

public class OutputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자";

    private OutputView() {
    }

    public static void printInputCarNamesMessage() {
        printMessage(INPUT_CAR_NAMES_MESSAGE);
    }

    public static void printInputAttemptCountMessage() {
        printMessage(INPUT_ATTEMPT_COUNT_MESSAGE);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printRacingResult(List<List<CarSnapshot>> roundResults, List<String> winners) {
        printRoundResults(roundResults);
        printWinners(winners);
    }

    private static void printRoundResults(List<List<CarSnapshot>> roundResults) {
        for (List<CarSnapshot> roundResult : roundResults) {
            for (CarSnapshot car : roundResult) {
                printMessage(formatCarStatus(car));
            }
            System.out.println();
        }
    }

    private static String formatCarStatus(CarSnapshot car) {
        return String.format("%s : %s", car.carName(), "-".repeat(car.position()));
    }

    private static void printWinners(List<String> winners) {
        printMessage(String.format("%s : %s", FINAL_WINNER_MESSAGE, String.join(", ", winners)));
    }
}
