package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class GameService {
    private Game game;

    public Game getGame() {
        return game;
    }

    public void init(Integer round, List<String> carNames) {
        this.game = Game.createGame(round, createRacingCars(carNames));
    }

    public List<RacingCar> createRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : carNames) {
            racingCars.add(RacingCar.createRacingCar(name));
        }
        return racingCars;
    }

    public List<RacingCar> executeLogic() {
        for (RacingCar racingCar : game.getRacingCars()) {
            Integer randomNumber = GameUtil.randomNumber();
            if (GameUtil.isForward(randomNumber)) {
                racingCar.addScore();
            }
        }
        return game.getRacingCars();
    }

    public List<String> selectWinner() {
        Optional<RacingCar> firstWinner = game.getRacingCars().stream().max(Comparator.comparing(RacingCar::getScore));

        if (firstWinner.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_WINNER);
        }

        Integer maxScore = firstWinner.get().getScore();

        List<String> winners = new ArrayList<>();

        for (RacingCar racingCar : game.getRacingCars()) {
            if (racingCar.getScore().equals(maxScore)) {
                winners.add(racingCar.getName());
            }
        }
        return winners;
    }
}
