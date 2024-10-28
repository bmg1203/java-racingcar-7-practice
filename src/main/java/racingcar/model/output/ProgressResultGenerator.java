package racingcar.model.output;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.car.Car;

public class ProgressResultGenerator {

	private static final String CAR_MOVEMENT_SYMBOL = "-";
	private static final String SEPARATOR = " : ";
	private static final String LINE_SEPARATOR = "\n";

	public static String generateProgressResult(List<Car> cars) {
		return cars.stream()
				.map(ProgressResultGenerator::generateCarStatus)
				.collect(Collectors.joining(LINE_SEPARATOR));
	}

	private static String generateCarStatus(Car car) {
		return car.getName() + SEPARATOR + formatMovementStatus(car.getMovement());
	}

	private static String formatMovementStatus(int number) {
		return CAR_MOVEMENT_SYMBOL.repeat(number);
	}
}
