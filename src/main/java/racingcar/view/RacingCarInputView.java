package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCarInfo;

public class RacingCarInputView {
    public RacingCarInfo readInfo() {
        return RacingCarInfo.map(
            readCarName(),
            readTrialNum()
        );
    }

    private String readCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private String readTrialNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}
