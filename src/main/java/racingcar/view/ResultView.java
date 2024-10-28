package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class ResultView {

    public static void printRoundResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}