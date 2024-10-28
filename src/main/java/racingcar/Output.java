package racingcar;

import java.util.List;

public class Output {
    private static final String ONE_STEP = "-";

    public void printResultString() {
        System.out.println("실행 결과");
    }

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName());
            System.out.print(" : ");
            System.out.println(ONE_STEP.repeat(car.getLocation()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (String winner : winners) {
            System.out.print(winner);
        }
    }
}
