package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.List;

public class RaceService {




    public void runRound(List<Car> cars){
        for (Car car : cars) {
            if (shouldMoveForward(generateRaandomDigit())){
                car.moveForward();
            }
        }
    }

    public boolean shouldMoveForward(int randomDigit) {
        return randomDigit >= 4;
    }

    public int generateRaandomDigit() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
