package racingcar.domain;

import java.util.List;

import racingcar.domain.Car.Car;
import racingcar.domain.Car.CarNames;

public class Race {
	private Attempt attempt;
	private List<Car> cars;
	private CarNames winner;

	public Race(Attempt attempt, List<Car> cars) {
		this.attempt = attempt;
		this.cars = cars;
	}

	public static Race from(Attempt attempt, List<Car> cars) {
		return new Race(attempt, cars);
	}
}
