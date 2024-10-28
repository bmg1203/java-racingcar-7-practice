package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingService;

import java.util.concurrent.TimeoutException;


public class RacingcarController {
    public final RacingService racingService;

    public RacingcarController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void getUserInput() throws IllegalArgumentException{
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesOfCars = Console.readLine();
        if (namesOfCars.isBlank()) {
            throw new IllegalArgumentException("경주할 자동차 이름을 입력하세요.");
        }
        else if (namesOfCars.charAt(namesOfCars.length()-1) == ',') {
            throw new IllegalArgumentException("이름을 입력하지 않은 자동차가 있습니다.");
        }
        racingService.separateCarNames(namesOfCars);

        int numberOfRaces;
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            numberOfRaces = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수에 숫자를 입력하세요.");
        }
        if (numberOfRaces >= 1000) {
            throw new IllegalArgumentException("시도 횟수가 1000 이상입니다.");
        }
        racingService.race(numberOfRaces);
    }
}
