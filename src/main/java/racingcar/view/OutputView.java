package racingcar.view;

import java.util.List;
import racingcar.dto.RacingResponseDto;
import racingcar.model.result.CarRecord;
import racingcar.model.result.RoundResult;

public class OutputView {
    private static final String ROUND_RESULT_START_MESSAGE = "실행 결과";

    private final StringBuilder stringBuilder = new StringBuilder();

    public void printRacingResponse(RacingResponseDto racingResponseDto) {
        clearStringBuilder();

        appendAllRoundResults(racingResponseDto.roundResults());
        appendWinners(racingResponseDto.winners());

        System.out.println(stringBuilder.toString());
        clearStringBuilder();
    }

    private void appendAllRoundResults(List<RoundResult> roundResults) {
        stringBuilder.append("\n")
                .append(ROUND_RESULT_START_MESSAGE)
                .append("\n");
        for (RoundResult roundResult : roundResults) {
            appendRoundResult(roundResult);
        }
    }

    private void appendRoundResult(RoundResult roundResult) {
        for (CarRecord record : roundResult.getRoundResult()) {
            stringBuilder
                    .append(record.getCarName())
                    .append(" : ")
                    .append(buildDistanceGraph(record.getMovedDistance()))
                    .append("\n");
        }
        stringBuilder.append("\n");
    }

    private void appendWinners(List<String> winners) {
        stringBuilder.append("최종 우승자 : ")
                .append(joinWinners(winners));
    }

    private String joinWinners(List<String> winners) {
        return String.join(", ", winners);
    }

    private String buildDistanceGraph(int distance) {
        return "-".repeat(distance);
    }

    private void clearStringBuilder() {
        if (!stringBuilder.isEmpty()) {
            stringBuilder.setLength(0);
        }
    }
}
