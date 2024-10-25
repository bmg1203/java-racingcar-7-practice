package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String matchCount = Console.readLine();

        System.out.println("실행 결과");
        RacePreparation racePreparation = new RacePreparation(input, matchCount);
        Race race = new Race(racePreparation, new RandomNumberGenerator());

        List<String> winners = race.getWinner();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
