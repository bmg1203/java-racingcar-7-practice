package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void printExecutionResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printCurrentRoundRacingResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getForwardCount()));
        }
        System.out.println();
    }

    public void printFinalRacingResult(List<String> winnerNames) {
        System.out.print("최종 우승자 : " + String.join(", ", winnerNames));
    }

}
