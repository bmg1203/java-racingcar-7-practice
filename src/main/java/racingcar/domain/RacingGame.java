package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    final List<Car> playRacingCarList;

    public RacingGame(List<Car> playRacingCarList){

        this.playRacingCarList = playRacingCarList;
    }

    public void runGame(int trialCount){

        for(int i = 0; i < trialCount; i++){

            playRacingCarList.forEach(this::moveForwardCar);

            OutputView.printOneGameResult(playRacingCarList);
        }

        OutputView.printWinner(findWinner());
    }

    public String findWinner() {

        int maxMoveCount = playRacingCarList.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);

        return playRacingCarList.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .collect(Collectors.joining(", "));

    }


    private void moveForwardCar(Car car){

        if(isGreaterThanOrEqualFour()){
            car.moveCarForward();
        }
    }

    private boolean isGreaterThanOrEqualFour() {

        return generateRandomNumberZeroToNine() >= 4;
    }

    private int generateRandomNumberZeroToNine(){

        return Randoms.pickNumberInRange(0, 9);
    }
}
