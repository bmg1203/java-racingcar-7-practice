package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;

	private int location;

	private static final int START_LOCATION = 0;
	private static final int MAX_NAME_LENGTH = 5;
	private static final int MOVE_THRESHOLD_VALUE = 4;
	private static final int MIN_RANDOM_NUM = 0;
	private static final int MAX_RANDOM_NUM = 9;

	public Car(String name) {
		validateCarLength(name);
		this.name = name;
		this.location = START_LOCATION;
	}

	private static void validateCarLength(String carName) {
		if (carName.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException();
		}
	}

	public void execute() {
		int randomNum = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
		if (randomNum >= MOVE_THRESHOLD_VALUE){
			moveForward();
		}
	}

	private void moveForward() {
		this.location ++;
	}

	public void printResult() {
		System.out.println(name + " : " + "-".repeat(location));
	}

	public int getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}
}
