package racingcar.view;

import racingcar.model.Cars;

public class RaceOutput {
    private static final String NEW_LINE = "%n"; // 플랫폼에 상관없이 개행 출력가능!
    private static final String PROGRESS = "-";
    private static final String PROGRESS_FORMAT = "%s : %s";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String WINNER_FORMAT = "최종 우승자 : %s";

    private RaceOutput() {
    }

    public static void println() {
        System.out.printf(NEW_LINE);
    }

    public static void println(String message) {
        System.out.printf(message);
        println();
    }

    public static void printProgress(Cars cars) {
        for (int i = 0; i < cars.count(); i++) {
            String progressMessage = String.format(
                    PROGRESS_FORMAT,
                    cars.nameAt(i),
                    PROGRESS.repeat(cars.countMoveAt(i))
            );

            println(progressMessage);
        }
    }

    public static void printWinner(Cars cars) {
        String winnersMessage = String.format(
                WINNER_FORMAT,
                String.join(WINNER_SEPARATOR, cars.getWinnerNames())
        );

        println(winnersMessage);
    }
}
