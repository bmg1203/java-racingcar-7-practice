package racingcar;


import racingcar.carRacingManager.CarRacingManager;
import racingcar.controller.Controller;
import racingcar.repository.CarRepository;
import racingcar.service.Service;
import racingcar.service.ServiceImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현

        CarRepository carRepository = new CarRepository();
        CarRacingManager carRacingManager = new CarRacingManager(carRepository);
        Service service = new ServiceImpl(carRepository, carRacingManager);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Controller controller = new Controller(service, carRepository, inputView, outputView);
        controller.play();

    }

}
