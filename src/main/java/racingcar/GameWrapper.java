package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameWrapper {

    private final GameService racingGameService = new GameService();

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        racingGameService.gameNameSet(Console.readLine());

        System.out.println("시도할 횟수는 몇 회인가요?");
        racingGameService.gameRoundSet(Console.readLine());

        System.out.println();
        System.out.println("실행 결과");
        racingGameService.playingGame();


    }

}
