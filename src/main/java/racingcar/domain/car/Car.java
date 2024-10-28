package racingcar.domain.car;

import racingcar.domain.name.Name;

public class Car {
	private static final int ADD_SCORE_NUMBER = 4;
	private final Name name;
	private int score;

	public Car(Name name) {
		this.name = name;
		this.score = 0;
	}

	public Car(Name name, int score) {
		this.name = name;
		this.score = score;
	}

	public void addScore() {
		this.score += 1;
	}

	public Name getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void processGame(int randomNumber) {
		if (randomNumber >= ADD_SCORE_NUMBER) {
			addScore();
		}
	}
}
