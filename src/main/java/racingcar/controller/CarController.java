package racingcar.controller;

import racingcar.model.Car;
import racingcar.util.Validator;
import racingcar.service.CarService;
import racingcar.util.StringUtil;
import racingcar.view.InputView;

import java.util.ArrayList;

public class CarController {
    private final InputView inputView = new InputView();
    private final Validator validator = new Validator();
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    public void createCars() {
        String input = inputView.inputCarNames();
        String[] strings = StringUtil.splitByComma(input);
        ArrayList<String> names = StringUtil.toArrayList(strings);
        ArrayList<Car> cars = new ArrayList<>();

        for (String name : names) {
            validator.validateCarName(name);
            Car car = new Car(name);
            cars.add(car);
        }

        carService.addCars(cars);
    }
}
