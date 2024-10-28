package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.InvalidCarNameException;

public class RacingCarList {
    private final List<RacingCar> racingCars = new ArrayList<>();
    private final MoveStrategy moveStrategy;

    public RacingCarList(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void moveAllCars() {
        for (RacingCar racingCar : racingCars) {
            racingCar.checkMoveForwardAndMove(moveStrategy);
        }
    }

    public void addRacingCar(String name) {
        validateDuplicatedCarName(name);
        RacingCar racingCar = new RacingCar(name);
        racingCars.add(racingCar);
    }

    private void validateDuplicatedCarName(String newRacingCarName) {
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getName().equals(newRacingCarName))
                throw new InvalidCarNameException("중복된 이름의 자동차가 존재합니다.");
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<String> findWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            if(racingCar.getPosition()==maxPosition) {
                winners.add(racingCar.getName());
            }
        }

        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (RacingCar racingCar : racingCars) {
            int position = racingCar.getPosition();
            if(maxPosition <=position) {
                maxPosition = position;
            }
        }

        return maxPosition;
    }

    public List<RacingCarStatus> getRacingCarsStatus() {
        List<RacingCarStatus> racingCarsStatus = new ArrayList<>();
        for(RacingCar racingCar : racingCars) {
            racingCarsStatus.add(new RacingCarStatus(racingCar.getName(),racingCar.getPosition()));
        }
        return racingCarsStatus;
    }
}
