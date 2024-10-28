package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Number;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final Number number;
    private final Cars cars;
    private String inputString;
    private int tryCount;

    public RacingCarGame(InputView inputView, OutputView outputView, Number number, Cars cars) { //의존성 주입 다시 공부하기
        this.inputView = inputView;
        this.outputView = outputView;
        this.number = number;
        this.cars = cars;
        this.inputString = "";
        this.tryCount = 0;
    }

    public void initGame() {
        outputView.printStartMessage();
        this.inputString = inputView.getInput();

        outputView.printTryCountMessage();
        this.tryCount = Integer.parseInt(inputView.getInput());

        cars.setCarList(inputString);
    }

    public void startGame() {
        outputView.printResultMessage();
        while (tryCount-- > 0) {
            playOneRound();
        }

        List<String> winnerList = cars.getWinnerList();
        outputView.printWinner(winnerList);
    }

    private void playOneRound() {
        for (Car car : cars.getCarList()) {
            car.setDistance(number.getRandomNumber());
            outputView.printCarDistance(car.getName(), car.getDistance());
        }
        outputView.printEmptyLine();
    }
}
