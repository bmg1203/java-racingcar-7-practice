package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int rounds;

    public RacingGame(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    // 모든 자동차가 한 라운드씩 이동
    public void playRound() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue); // 각 자동차의 전진 여부 결정
        }
    }

    // 우승자 결정 메서드
    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
