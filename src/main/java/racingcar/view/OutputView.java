package racingcar.view;

import java.util.List;

import racingcar.dto.RaceResultResponse;

public class OutputView {
	public void promptCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public void promptAttemptCount() {
		System.out.println("시도할 횟수는 몇 회인가요?");
	}

	public void printRaceResultPrompt() {
		System.out.println("실행 결과");
	}

	public void printRaceStatus(List<RaceResultResponse> raceResultResponses) {
		raceResultResponses.forEach(raceResultResponse -> {
			String result = raceResultResponse.name() + " : " + raceResultResponse.distance();
			System.out.println(result);
		});
	}

	public void printNewLine() {
		System.out.println();
	}
}
