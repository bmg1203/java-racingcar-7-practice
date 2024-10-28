package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.dto.CarMovementResponse;
import racingcar.dto.WinnerResponse;

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

	public void printNewLine() {
		System.out.println();
	}

	public void printRaceStatus(List<CarMovementResponse> carMovementResponses) {
		carMovementResponses.forEach(carMovementResponse ->
			System.out.println(buildMovementString(carMovementResponse)));
	}

	public void printWinners(List<WinnerResponse> winnerResponses) {
		String winners = winnerResponses.stream()
			.map(WinnerResponse::name)
			.collect(Collectors.joining(", "));

		System.out.print("최종 우승자 : " + winners);
	}

	private String buildMovementString(CarMovementResponse carMovementResponse) {
		return carMovementResponse.name() + " : " + "-".repeat(carMovementResponse.distance());
	}
}
