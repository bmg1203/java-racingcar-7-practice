package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarSimulator {
	private List<String> carNames;
	private long iterationCount;
	private List<Long> carPosition;

	public RacingCarSimulator() {
		carNames = null;
		iterationCount = 0;
		carPosition = null;
	}

	public void run() {
		carNames = inputCarName();
		iterationCount = inputIterationCount();

		initCarPosition();
		simulate();
		printWinner();
	}

	private List<String> inputCarName() {
		String input = Console.readLine();
		return StringParser.parseCarNames(input);
	}

	private long inputIterationCount() {
		String input = Console.readLine();
		return StringParser.parsePositiveNumber(input);
	}

	private void initCarPosition() {
		// TODO : 미구현
	}

	private void simulate() {
		// TODO : 미구현
	}

	private void printWinner() {
		// TODO : 미구현
	}
}
