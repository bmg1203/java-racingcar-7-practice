package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {
    public void run(){
        OutputView.printCarNamesPrompt();
        InputView inputView = new InputView();

        String carInput = inputView.input();
        String[] carInputs = carInput.split(",");

        List<String> cars = new ArrayList<>();
        for (int i = 0; i < carInputs.length; i++) {
            cars.add(carInputs[i]);
        }

        OutputView.printAttemptCountPrompt();

        int tryCount = Integer.parseInt(inputView.input());




    }
}
