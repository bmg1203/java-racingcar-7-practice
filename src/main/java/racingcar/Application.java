package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final RacingManager racingManager = new RacingManager();

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawName = Console.readLine();
        racingManager.assignCars(rawName);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String rawTrials = Console.readLine();
        racingManager.assignTrials(Integer.parseInt(rawTrials));
    }
}
