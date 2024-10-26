package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import racingcar.exception.ExceptionUtils;
import racingcar.exception.GeneralError;

public class RacingView {

    private String readline() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            ExceptionUtils.throwIllegalArgException(GeneralError.EMPTY_INPUT);
        }
        return null;
    }


    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        return this.readline();
    }

    public String inputRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return this.readline();
    }

    public void printRoundResult(Map<String, Integer> carPositions) {
        carPositions.forEach((name, position) ->
                System.out.println(name + " : " + "-".repeat(position))
        );
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void viewClose() {
        Console.close();
    }
}


