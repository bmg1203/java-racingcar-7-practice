package racingcar.mvc.controller.racingGameManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.mvc.model.observer.CarRacer;
import racingcar.mvc.model.observer.Racer;
import racingcar.mvc.model.subject.RacingGameRound;
import racingcar.mvc.validation.input.CarNameValidator;

public class CarRacingGameManager extends RacingGameManager {
    @Override
    public List<Racer> createRacers(String nameString) {
        List<Racer> racers = new ArrayList<>();

        CarNameValidator.isValid(nameString);

        for (String name : nameString.split(CarNameValidator.NAME_DELIMITER)) {
            racers.add(new CarRacer(name));
        }

        return racers;
    }

    @Override
    public RacingGameRound initGameRound(RacingGameRound gameRound, List<Racer> racers) {
        this.gameRound = gameRound;

        for (Racer racer : racers) {
            gameRound.registerObserver(racer);
        }

        return this.gameRound;
    }

    @Override
    public List<Racer> goRound() {
        gameRound.notifyObservers();

        return gameRound.getRacers();
    }

    public List<Racer> getWinners() {
        List<Racer> racers = gameRound.getRacers();

        Collections.sort(racers, Comparator.comparing(Racer::getDistance));

        int winnerDistance = findWinnerDistance(racers);

        return racers.subList(lowerBound(racers, winnerDistance), upperBound(racers, winnerDistance));
    }

    private int findWinnerDistance(List<Racer> racers) {
        return racers.getLast().getDistance();
    }

    private int upperBound(List<Racer> racers, int winnerDistance) {
        int begin = 0;
        int end = racers.size();

        while (begin < end) {
            int mid = (begin + end) / 2;

            if (racers.get(mid).getDistance() <= winnerDistance) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private int lowerBound(List<Racer> racers, int winnerDistance) {
        int begin = 0;
        int end = racers.size();

        while (begin < end) {
            int mid = (begin + end) / 2;

            if (racers.get(mid).getDistance() >= winnerDistance) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return end;
    }

}
