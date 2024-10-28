package racingcar.domain.entity;

import java.util.List;

import racingcar.common.util.RandomsWrapper;
import racingcar.domain.entity.car.Car;
import racingcar.domain.vo.CarVO;

public class Race {
	private final List<Car> participants;
	private final Attempt attempt;

	public Race(Attempt attempt, List<Car> participants) {
		this.attempt = attempt;
		this.participants = participants;
	}

	public static Race from(Attempt attempt, List<Car> cars) {
		return new Race(attempt, cars);
	}

	public boolean canProgress() {
		if (attempt.isRemained()) {
			participants.forEach(car -> car.forward(RandomsWrapper.getInt()));
			return true;
		}
		return false;
	}

	public String[][] createResultSentence() {
		return participants.stream()
			.map(Car::createResultSentence)
			.toArray(String[][]::new);
	}

	public List<CarVO> toCarVOList() {
		return participants.stream()
			.map(Car::toCarStatus)
			.toList();
	}
}
