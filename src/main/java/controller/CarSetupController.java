package controller;

import factory.CarFactory;
import java.util.List;
import model.Car;
import util.ParsingUtil;
import validator.AttemptNumberValidator;
import validator.CarNameValidator;
import view.InputView;

public class CarSetupController {
    private final InputView inputView;
    private final CarFactory carFactory;

    public CarSetupController(InputView inputView, CarFactory carFactory) {
        this.inputView = inputView;
        this.carFactory = carFactory;
    }

    public List<Car> getCarsFromUserInput() {
        String userInput = inputView.getCarNames();
        List<String> carNames = ParsingUtil.carNamesToList(userInput);
        CarNameValidator.isValid(carNames); // 검증

        return createCars(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        return carFactory.createCars(carNames);
    }

    public int getAttemptCount() {
        String input = inputView.getAttemptCount();
        AttemptNumberValidator.checkAttempt(input); //검증
        return Integer.parseInt(input);
    }
}
