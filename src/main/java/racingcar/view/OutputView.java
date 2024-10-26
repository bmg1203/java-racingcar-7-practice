package racingcar.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class OutputView {

    public void printStart() {
        System.out.println("실행 결과");
    }

    public void printRound(LinkedHashMap<String, Integer> cars) {
        for (Entry<String, Integer> car : cars.entrySet()) {
            System.out.println(car.getKey() + " : " + "-".repeat(car.getValue()));
        }
        System.out.println();
    }

    public void printWinners(LinkedHashMap<String, Integer> cars) {
        List<String> winners = new ArrayList<>();

        final int winnerScore = Collections.max(cars.values());

        for (Entry<String, Integer> car : cars.entrySet()) {
            if (car.getValue() == winnerScore) {
                winners.add(car.getKey());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
