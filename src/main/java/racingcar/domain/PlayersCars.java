package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayersCars {
    private List<Car> playersCars;

    public PlayersCars(List<String> userNames) {
        playersCars = new ArrayList<>();
        for (String each : userNames) {
            this.playersCars.add(new Car(each));
        }
    }

    public List<Car> getPlayersCars() {
        return playersCars;
    }

    public void moveSequence(NumberGenerator numberGenerator) {
        for (Car each : playersCars) {
            each.moveCar(numberGenerator.generateNumber());
        }
    }

    public List<String> findMaximumScoreCars() {
        int maxScore = playersCars.stream()
                .mapToInt(car -> car.getScore().getScoreValue())
                .max()
                .orElse(-1);

        return playersCars.stream()
                .filter(car -> car.getScore().getScoreValue() == maxScore)
                .map(Car::getUserName)
                .toList();
    }
}
