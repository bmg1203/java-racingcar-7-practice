package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        Racing racing = new Racing(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int number = Integer.parseInt(Console.readLine());

        racing.race(number);
    }
}
