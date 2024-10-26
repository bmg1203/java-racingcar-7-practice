package racingcar.view.output;

import racingcar.GameResult;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputPrinter {

    private BigInteger totalMaxPosition = BigInteger.ZERO;
    private int attemptCount;
    private Map<String, List<BigInteger>> carPositionLog;

    public void printResult(GameResult gameResult) {
        this.attemptCount = gameResult.getAttemptCount();
        this.carPositionLog = gameResult.getCarPositionLog();
        System.out.println("\n실행 결과");
        printCarMovement();
        printWinner();
    }

    public void printWinner() {
        List<String> winners = new ArrayList<>();
        for (String name : carPositionLog.keySet()) {
            List<BigInteger> resultPositions = carPositionLog.get(name);
            BigInteger resultPosition = resultPositions.getLast();
            if (totalMaxPosition.compareTo(resultPosition) == 0) {
                winners.add(name);
            }
        }
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }

    public void printCarMovement() {
        for (int step = 0; step < attemptCount; step++) {
            printStepResult(step);
            System.out.println();
        }
    }

    private void printStepResult(int step) {
        for (String name : carPositionLog.keySet()) {
            List<BigInteger> positions = carPositionLog.get(name);
            BigInteger stepPosition = positions.get(step);

            printCarName(name);
            printStepPosition(stepPosition);

            if (totalMaxPosition.compareTo(stepPosition) < 0) {
                totalMaxPosition = stepPosition;
            }
        }
    }

    private void printCarName(String name) {
        System.out.print(name + " : ");
    }

    private void printStepPosition(BigInteger stepPosition) {
        for (BigInteger i = BigInteger.ZERO; i.compareTo(stepPosition) < 0; i = i.add(BigInteger.ONE)) {
            System.out.print("-");
        }
        System.out.println();
    }
}
