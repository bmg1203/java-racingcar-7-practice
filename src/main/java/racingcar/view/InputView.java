package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String promptCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesString = Console.readLine();
        return carNamesString;
    }

    public String promptAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptCountString = Console.readLine();
        return attemptCountString;
    }


}
