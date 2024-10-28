package racingcar.io;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputHandler {

    private static final String WINNER_NOTATION_DELIMITER = ", ";

    public void showGameStartComment() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showTryCountComment() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void showResultComment() {
        System.out.println("실행 결과");
    }

    public void showWinners(final List<Car> cars) {
        String carsName = generateWinnerCarsName(cars);
        System.out.printf("최종 우승자 : %s", carsName);
    }

    public void showCarsPosition(final List<Car> cars) {
        cars.forEach(this::currentPositionFrom);
        System.out.println();
    }

    private String generateWinnerCarsName(final List<Car> cars) {
        return cars.stream()
            .map(Car::getName)
            .collect(Collectors.joining(WINNER_NOTATION_DELIMITER));
    }

    private void currentPositionFrom(final Car car) {
        System.out.println(car.getCurrentSituation());
    }

}
