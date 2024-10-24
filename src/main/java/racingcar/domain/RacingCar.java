package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.view.OutputView;

public class RacingCar {
    private final int tryNumber;
    private final Cars cars;

    public RacingCar(int tryNumber, Cars cars) {
        if (tryNumber <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 큰 양수여야 합니다.");
        }
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public Cars race() {
        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            this.cars.getCars().forEach(car -> {
                int randomNumber = pickRandomNumber();
                if (randomNumber >= 4) {
                    car.movePosition();
                }
                OutputView.showRaceResult(car.getName(), car.getPosition());
            });
            System.out.println();
        }
        return cars;
    }

    public String calculateFinalWinner(Cars cars) {
        List<Car> carList = cars.getCars();
        int maxPosition = calculateMaxPosition(carList.stream());

        Stream<Car> winners = carList.stream().filter(car -> car.getPosition() == maxPosition);
        return winners.map(Car::getName).collect(Collectors.joining(","));
    }

    private static int calculateMaxPosition(Stream<Car> carList) {
        return carList.map(Car::getPosition).max(Integer::compareTo).orElse(0);
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
