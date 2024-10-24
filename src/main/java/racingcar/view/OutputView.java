package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void executionResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void currentStatusMessage(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void finalWinnerMessage(List<Car> winners) {
        List<String> carNames = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
        String message = "최종 우승자 : " + String.join(", ", carNames);
        System.out.println(message);
    }



}
