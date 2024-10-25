package racingcar.model;

import java.util.List;

public class WinnerResultGenerator {

	private static final int SINGLE_WINNER_COUNT = 1;
	private static final String SEPARATOR = ", ";

	private static String generateJointWinnersResult(List<String> winners) {
		return String.join(SEPARATOR, winners);
	}
}
