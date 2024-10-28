package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public static void printCarNamesRequest() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printAttemptCountRequest() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printCarsPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(getCarPosition(car));
        }
        System.out.print("\n");
    }

    private static String getCarPosition(Car car) {
        return String.format("%s : %s%n", car.getName(), "-".repeat(car.getDistance()));
    }

    public static void printWinner(List<Car> winners) {
        List<String> winnersName = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println("최종 우승자 : " + String.join(", ", winnersName));
    }
}
