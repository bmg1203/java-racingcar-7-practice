package racingcar;

import racingcar.IO.CarNamesInput;
import racingcar.IO.NumberOfIterationInput;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = CarNamesInput.getCarNames();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int iteration = NumberOfIterationInput.getIteration();

        System.out.println("\n실행 결과");
        new IsMovable(carNames, iteration).getIsMovable();
    }
}
