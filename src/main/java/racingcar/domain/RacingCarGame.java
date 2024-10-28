package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.validate.CarNameValidation;

public class RacingCarGame {

    private final List<Car> cars = new ArrayList<>();
    public RacingCarsGroup racingCarsGroup;
    public GameRoundHistory gameRoundHistory = new GameRoundHistory();

    public RacingCarGame() {
    }

    public RacingCarGame(List<String> carNames) {
        CarNameValidation carNameValidation = new CarNameValidation();
        carNameValidation.validateName(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        racingCarsGroup = new RacingCarsGroup(cars);
    }

    public String playCarGame(int inputNumbersOfAttempts) {
        for (int i = 0; i < inputNumbersOfAttempts; i++) {
            moveEachCars(generateMove(cars.size()));
            gameRoundHistory.storeGameRoundHistory(cars);
        }

        gameRoundHistory.storeFinalWinners(racingCarsGroup.getFinalWinners(cars));
        return gameRoundHistory.getEachRoundResult();
    }

    public List<Integer> generateMove(int totalCars) {
        List<Integer> moves = new ArrayList<>();
        for (int i = 0; i < totalCars; i++) {
            int move = Randoms.pickNumberInRange(0, 9);
            moves.add(move);
        }
        return moves;

    }

    public void moveEachCars(List<Integer> moves) {
        List<Car> cars = racingCarsGroup.getCars();
        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i) >= 4) {
                cars.get(i).increasePosition();
            }
        }
    }

}
