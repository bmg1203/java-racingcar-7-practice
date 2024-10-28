package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.parser.CarNameInputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
	private final InputView inputView;
	private final OutputView outputView;

	public RacingController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		String carNameInput = readCarNameInput();
		List<String> carNames = parseCarNameInput(carNameInput);
		Cars cars = createCars(carNames);

		int attemptCount = readAttemptCountInput();

		printRaceResult(attemptCount, cars);
		printWinners(cars);
	}

	private String readCarNameInput() {
		outputView.promptCarName();

		return inputView.readCarNameInput();
	}

	private List<String> parseCarNameInput(String carNameInput) {
		CarNameInputParser carNameInputParser = new CarNameInputParser();

		return carNameInputParser.parseInput(carNameInput);
	}

	private Cars createCars(List<String> carNames) {
		List<Car> cars = carNames.stream()
			.map(Car::new)
			.toList();

		return new Cars(cars);
	}

	private int readAttemptCountInput() {
		outputView.promptAttemptCount();

		return inputView.readAttemptCountInput();
	}

	private void printRaceResult(int attemptCount, Cars cars) {
		outputView.printNewLine();
		outputView.printRaceResultPrompt();
		for (int i = 0; i < attemptCount; i++) {
			cars.moveEachCars();
			outputView.printRaceResult(cars.findRaceStatus());
			outputView.printNewLine();
		}
	}

	private void printWinners(Cars cars) {
		outputView.printWinners(cars.selectWinners());
	}
}
