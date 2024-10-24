package racingcar.view;

import racingcar.domain.Car;

public class OutputView {
    public void printEndLine() {
        System.out.println();
    }

    public void printExecutionResultMessage() {
        System.out.println("실행 결과");
    }

    public void printEachExecutionResult(final Car car) {
        String dashString = getDashString(car.getLocation());
        System.out.println(car.getName() + " : " + dashString + " ");
    }

    public void printWinner(final Car car) {
        System.out.println("최종 우승자 : " + car.getName());
    }

    private static String getDashString(final int dashCount) {
        return "-".repeat(Math.max(0, dashCount));
    }
}
