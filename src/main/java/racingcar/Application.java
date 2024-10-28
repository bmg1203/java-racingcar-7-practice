package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int turn = Integer.parseInt(Console.readLine());
        System.out.println();

        String[] carNames = input.split(",");
        List<Car> cars = Arrays.stream(carNames)
                .map(Car::new)
                .toList();

        RacingGame game = new RacingGame(cars, turn);
        game.start();
    }
}
