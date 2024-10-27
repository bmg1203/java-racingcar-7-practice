package racingcar.View;

import java.util.List;
import racingcar.Model.Car;

public class OutputView {
    public static void printRoundResults(List<Car> cars) {
        for (var car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}

