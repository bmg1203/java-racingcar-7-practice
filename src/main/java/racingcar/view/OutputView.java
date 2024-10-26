package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자 : ";

    public static void printResult() {
        System.out.println();
        System.out.println(RESULT);
    }

    public static void printRacing(List<Map<String, Integer>> cars) {
        for (Map car : cars) {
            printCarPosition(car);
        }
    }

    public static void printCarPosition(Map<String, Integer> cars) {
        cars.forEach((name, position) ->
            System.out.println(name + " : " + "-".repeat(position)));
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        System.out.println(WINNER + String.join(", ", winners));
    }
}
