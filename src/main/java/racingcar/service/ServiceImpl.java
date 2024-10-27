package racingcar.service;

import java.util.List;
import racingcar.carRacingManager.CarRacingManager;
import racingcar.domian.TryNumber;
import racingcar.domian.car.Car;
import racingcar.repository.CarRepository;
import racingcar.view.OutputView;

public class ServiceImpl implements Service {
    private CarRepository carRepository;
    private CarRacingManager carRacingManager;


    public ServiceImpl(CarRepository carRepository, CarRacingManager carRacingManager) {
        this.carRepository = carRepository;
        this.carRacingManager = carRacingManager;
    }

    public void saveCars(String[] carNames) {

        for (String carName : carNames) {
            Car car = Car.createCar(carName);
            carRepository.saveCarRepository(car);
        }

    }

    public void play(String inputTryNumber) {
        TryNumber tryNumber = TryNumber.createTryNumber(inputTryNumber);
        int integerTryNumber = tryNumber.getTryNumber();
        List<Car> cars = carRepository.findAll();
        for (int i = 0; i < integerTryNumber; i++) {
            carRacingManager.executeRace(cars);
            OutputView.showProcessView(cars);
        }
    }


    public List<Car> whoIsWinner() {
        return carRacingManager.checkWhoIsWinner();
    }


}
