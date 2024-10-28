package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarView {

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String inputRound() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return Console.readLine();
    }

    public void printRoundResult(String roundResult) {
        System.out.println("실행 결과");
        System.out.println(roundResult);
        System.out.println();
    }

    public void printRaceResult(String raceResult) {
        System.out.println("최종 우승자 : " + raceResult);
    }
}
