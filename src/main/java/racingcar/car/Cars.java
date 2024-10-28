package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String[] players) {
        cars = Arrays.stream(players)
                .map(player -> new Car(player.trim()))
                .toList();
    }

    public void run() {
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            car.move(randomNum);
        }
    }

    public List<String> getResults() {
        final String MOVING_SYMBOL = "-";
        return cars.stream()
                .map(car -> car.getName() + " : " + car.getPosition() + "\n")
                .collect(Collectors.toList());
    }

    public String getWinners() {
        int winnerPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }
}
