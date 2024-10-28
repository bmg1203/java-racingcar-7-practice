package racingcar.controller;

import racingcar.model.RacingCarRepository;
import racingcar.validator.Validator;
import racingcar.view.RacingCarIO;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCarController {
    private final RacingCarIO racingCarIO;
    private final RacingCarRepository racingCarRepository;
    private final Validator validator;

    public RacingCarController(RacingCarIO racingCarIO, RacingCarRepository racingCarRepository, Validator validator) {
        this.racingCarIO = racingCarIO;
        this.racingCarRepository = racingCarRepository;
        this.validator = validator;
    }

    public void getCarList() {
        String carInfo = racingCarIO.getCarInfo();

        ArrayList<String> cars = validator.splitByComma(carInfo);
        ArrayList<String> refinedCars = validator.changeSameName(cars);

        for (String car : refinedCars) {
            racingCarRepository.addCar(car);
        }
    }

    public void getTryCount() {
        String tryCountStr = racingCarIO.tryCountInfo();

        Long tryCount = validator.convertTryCount(tryCountStr);

        racingCarRepository.setTryCount(tryCount);
    }

    public void calculateRandomNumber() {
        Long tryCount = racingCarRepository.getTryCount();
        ArrayList<String> cars = racingCarRepository.getCars();

        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < cars.size(); j++) {
                int result = pickNumberInRange(0, 9);
                if (result >= 4) {
                    racingCarRepository.plusValue(j);
                }
            }
        }
    }

    public void calculateWinner() {


        racingCarIO.printWinners();
    }
}
