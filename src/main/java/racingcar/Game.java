package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Game {
    private final List<Car> cars = new ArrayList<>();
    private int attempts;

    public void start() {
        inputCarNames();
        inputAttempts();
        runRace();
        printWinners();
    }

    private void inputCarNames() {
        String[] carNames = InputHandler.getCarNames();
        Validator.validateCarNames(carNames);

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void inputAttempts() {
        attempts = InputHandler.getAttempts();

        Validator.validateAttempts(attempts);
    }

    private void runRace() {
        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            moveEachCar();
            printCurrentStatus(cars);
        }
    }

    private void moveEachCar() {
        for (final Car car : cars) {
            final int number = pickNumberInRange(0, 9);
            if (number >= 4) {
                car.move();
            }
        }
    }

    private List<String> getWinners() {
        // 우승자의 position 추출
        int maxPosition = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(() -> new IllegalArgumentException("경주에 참가한 자동차가 없습니다."))
                .getPosition();

        // maxPosition과 같은 값을 가지는 자동차 추출
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private void printWinners() {
        List<String> winners = getWinners();
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }

    private void printCurrentStatus(List<Car> cars) {
        for (final Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
