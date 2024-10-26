package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.CarRaceView;

import java.util.ArrayList;
import java.util.List;

public class CarRaceController {
    private final CarRaceView view;
    private final List<Car> cars;

    public CarRaceController() {
        this.view = new CarRaceView();
        this.cars = new ArrayList<>();
    }

    public void startRace() {
        String carNamesInput = view.getCarNames();
        validateCarNames(carNamesInput);
        initializeCars(carNamesInput);
        int tryCount = view.getTryCount();
        runRace(tryCount);
    }

    private void validateCarNames(String carNamesInput) {
        if (carNamesInput.trim().isEmpty() || carNamesInput.contains(" ")) {
            throw new IllegalArgumentException("공백 없이 입력해주세요.");
        }
    }

    private void initializeCars(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        for (String name : carNames) {
            String trimmedName = name.trim();
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(trimmedName));
        }
    }

    private void runRace(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            view.printCarsPosition(cars);
        }
        view.displayWinners(cars);
    }
}
