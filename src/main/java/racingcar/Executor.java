package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Executor {
    private final String operator = ",";
    private final int nameLengthLimit = 5;
    private final int moveStandard = 4;

    private long repeatCount;
    private List<Car> cars = new ArrayList<>();
    private List<Car> winners = new ArrayList<>();

    private final IOController ioController;
    private final Parser parser;
    private final Validator validator;


    Executor(IOController ioController, Parser parser, Validator validator) {
        this.ioController = ioController;
        this.parser = parser;
        this.validator = validator;
    }

    public void run() {
        String inputCarNamesStr = ioController.enterCarNames();
        String inputRepeatCountStr = ioController.enterRepeatCount();

        validator.validateCarNamesInput(inputCarNamesStr);
        List<String> carNames = parser.parseCarNamesByOperator(inputCarNamesStr, operator);

        validator.validateCarNamesLength(carNames, nameLengthLimit);
        cars = Car.createCarsByName(carNames);

        validator.validateRepeatCount(inputRepeatCountStr);
        repeatCount = parser.parseRepeatCount(inputRepeatCountStr);

        executeForCount(cars, repeatCount);

        winners = getWinners(cars);
        ioController.printWinners(winners);
    }


    private void executeForCount(List<Car> cars, long repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            moveCars(cars);
            ioController.printResults(cars);
        }
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        int randomVal = Randoms.pickNumberInRange(0, 9);
        if (moveStandard <= randomVal) {
            car.move();
        }
    }

    private List<Car> getWinners(List<Car> cars) {
        long maxMoveCount = 0;
        for (Car car : cars) {
            if (maxMoveCount < car.getMoveCount()) {
                maxMoveCount = car.getMoveCount();
            }
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxMoveCount == car.getMoveCount()) {
                winners.add(car);
            }
        }
        return winners;
    }
}
