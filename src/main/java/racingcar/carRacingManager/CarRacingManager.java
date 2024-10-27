package racingcar.carRacingManager;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import racingcar.carAction.CarAction;
import racingcar.carAction.CarForward;
import racingcar.carAction.CarStop;
import racingcar.carRace.CarRace;
import racingcar.domian.car.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.Winners;


public class CarRacingManager {
    private CarRepository carRepository;
    private Winners winners = Winners.createWinners();

    private static final CarAction CAR_ACTION_FORWARD = new CarForward();
    private static final CarAction CAR_ACTION_STOP = new CarStop();

    public CarRacingManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> checkWhoIsWinner() {
        List<Car> cars = sortCarRepository();
        Car winner = cars.get(0);
        int winnerPosition = winner.getPosition();
        saveWinners(cars, winnerPosition);
        return winners.findWinners();
    }

    private void saveWinners(List<Car> cars, int winnerPosition) {
        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                saveWinner(car);
            }
        }
    }

    private void saveWinner(Car car) {
        winners.addWinners(car);
    }


    private List<Car> sortCarRepository() {
        List<Car> cars = getCarRepository();
        Collections.sort(cars);
        return cars;
    }

    private List<Car> getCarRepository() {
        return carRepository.findAll();
    }


    public void executeRace(List<Car> cars) {
        for (Car car : cars) {
            int pickRandomNumber = Randoms.pickNumberInRange(0, 9);
            CarAction carAction = getCarAction(pickRandomNumber);
            CarRace carRace = CarRace.createCarRace(car, carAction);
            carRace.executeRace();
        }
    }

    private CarAction getCarAction(int pickRandomNumber) {
        if (pickRandomNumber >= 4) {
            return CAR_ACTION_FORWARD;

        }
        return CAR_ACTION_STOP;
    }

}
