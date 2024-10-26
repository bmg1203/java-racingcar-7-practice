package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingService;


public class RacingcarController {
    public final RacingService racingService;

    public RacingcarController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void getUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesOfCars = Console.readLine();
        racingService.separateCarNames(namesOfCars);
    }
}
