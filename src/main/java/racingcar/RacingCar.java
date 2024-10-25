package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import car.Car;
import io.RacingCarInputHandler;
import io.InputHandler;
import io.OutputHandler;
import io.RacingCarOutputHandler;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private InputHandler inputHandler = new InputHandler();
    private OutputHandler outputHandler = new OutputHandler();
    private RacingCarInputHandler racingCarInputHandler = new RacingCarInputHandler();
    private RacingCarOutputHandler racingCarOutputHandler = new RacingCarOutputHandler();

    public void run() {
        try {
            outputHandler.showInputCarNameMessage();
            String inputCarName = inputHandler.getInputCarName();
            List<String> separatedCarNameList = racingCarInputHandler.getSeparatedCarNameList(inputCarName);

            outputHandler.showInputRacingCountMessage();
            String inputRacingCount = inputHandler.getInputRacingCount();
            int racingCount = racingCarInputHandler.getRacingCount(inputRacingCount);

            List<Car> carList = getCarList(separatedCarNameList);

            racingMachine(carList, racingCount);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Car> getCarList(List<String> separatedCarNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : separatedCarNameList) {
            carList.add(Car.of(carName));
        }
        return carList;
    }

    public void racingMachine(List<Car> carList, int racingCount) {
        while (racingCount > 0) {
            racing(carList);
            racingCarOutputHandler.displayRaceResultsByRound(carList);
            racingCount--;
        }
    }

    private void racing(List<Car> carList) {
        for (Car car : carList) {
            int randomResult = Randoms.pickNumberInRange(0, 9);
            carMove(car, randomResult);
        }
    }

    private void carMove(Car car, int randomResult) {
        if (randomResult >= 4) {
            car.move();
        }
    }
}
