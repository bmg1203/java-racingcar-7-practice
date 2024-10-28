package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;
import java.util.stream.Collectors;

public class GameService {

    GameRepository gameRepository = new GameRepository();

    public void gameNameSet(String input) {
        gameRepository.setCarsNames(input);
    }


    public void gameRoundSet(String input) {
        gameRepository.setNumberOfRounds(input);
    }


    public void playingGame() {

        Map<String, Integer> cars = setCarPositionOnTheLine();
        for (int round = 0; round < gameRepository.roundOfGame(); round++) {
            roundOnRound(cars);
        }
        System.out.println("최종 우승자 : " + findingWinner(cars));

    }


    public Map<String, Integer> setCarPositionOnTheLine() {

        return gameRepository.getAllNames().stream()
                .collect(Collectors.toMap(name -> name, name -> 0));
    }

    public void roundOnRound(Map<String, Integer> cars) {

        String gauge = "-";
        for (String car : cars.keySet()) {
            int currentPosition = cars.get(car);
            int progress = movingForwards();
            currentPosition += progress;
            cars.put(car, currentPosition);
            System.out.println(car + " : " + gauge.repeat(currentPosition));
        }

        System.out.println();

    }

    public int movingForwards() {

        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return 1;
        } else {
            return 0;
        }

    }

    public String findingWinner(Map<String, Integer> cars) {

        int maxValue = 0;
        for (int score : cars.values()) {
            if (score > maxValue) {
                maxValue = score;
            }
        }

        for (Map.Entry<String, Integer> entry : cars.entrySet()) {
            String car = entry.getKey();
            Integer score = entry.getValue();

            if (score == maxValue) {
                gameRepository.selectWinner(car);
            }
        }

        return String.join(",", gameRepository.findWinner());
    }


}
