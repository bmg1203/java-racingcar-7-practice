package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = InputHandler.getCarsName();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptCount = InputHandler.getAttemptCount();

        RaceManager raceManager = new RaceManager(carNames, attemptCount);
        raceManager.runRace();
    }
}
