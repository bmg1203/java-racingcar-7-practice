package racingcar.model.winner;

import java.util.List;

import racingcar.model.car.Car;

public class WinnerDeterminer {

	private static final int MIN_MOVEMENT_VALUE = 0;

	public static List<String> determineWinner(List<Car> cars) {
		int maxMovementValue = getMaxMovementValue(cars);
		return getWinner(cars, maxMovementValue);
	}

	private static int getMaxMovementValue(List<Car> cars) {
		return cars.stream()
				.mapToInt(Car::getMovement)
				.max()
				.orElse(MIN_MOVEMENT_VALUE);
	}

	private static List<String> getWinner(List<Car> cars, int maxMovementValue) {
		return cars.stream()
				.filter(car -> car.getMovement() == maxMovementValue)
				.map(Car::getName)
				.toList();
	}
}
