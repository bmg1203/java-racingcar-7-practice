package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = Car.createCars(Console.readLine());
        game.registerCars(cars);
        System.out.println("시도할 횟수는 몇 회인가요?");
        game.setTryCount(Integer.parseInt(Console.readLine()));
        game.doGame();
        game.printResult();
        Console.close();
    }
}
