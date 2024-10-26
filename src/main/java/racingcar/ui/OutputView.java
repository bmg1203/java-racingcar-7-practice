package racingcar.ui;

import java.util.List;
import racingcar.domain.round.RoundResult;

public class OutputView {

    private final StringBuilder buffer = new StringBuilder();

    private void newLine() {
        System.out.println();
    }

    public void showPlayGame() {
        newLine();
        System.out.println("실행 결과");
    }

    public void showRacingResult(List<RoundResult> racingResult) {
        racingResult.forEach(roundResult -> buffer.append(roundResult.carName())
                .append(" : ")
                .append("-".repeat(roundResult.position()))
                .append('\n'));
        bufferClear();
        newLine();
    }

    private void bufferClear() {
        System.out.println(buffer);
        buffer.setLength(0);
    }

    public void showFinalWinners(List<String> finalWinners) {
        buffer.append("최종 우승자 : ").append(String.join(",", finalWinners));
        bufferClear();
    }

}
