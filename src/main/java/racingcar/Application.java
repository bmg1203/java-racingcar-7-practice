package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        CarNameHandler carNameHandler = new CarNameHandler();

        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNamesInput = Console.readLine();

            System.out.println("시도할 횟수는 몇 회인가요?");
            String movementInput = Console.readLine();
            int movement = Integer.parseInt(movementInput); // Convert input to integer

            RacingCars carData = carNameHandler.storeCar(carNamesInput);

            RacingGame racingGame = new RacingGame(carData);
            racingGame.startRacing(movement);

            carNameHandler.printWinCarNames(carData);
        } catch (NumberFormatException e) {
            System.err.println("잘못된 입력이 감지되었습니다: 시도 횟수는 숫자여야 합니다.");
        } catch (IllegalArgumentException e) {
            System.err.println("잘못된 입력이 감지되었습니다: " + e.getMessage());
        }
    }
}
