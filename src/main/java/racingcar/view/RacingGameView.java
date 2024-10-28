package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.ConditionCar;
import java.util.ArrayList;
import java.util.List;

public class RacingGameView {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        List<String> result = new ArrayList<>();
        for (String name : carNames) {
            result.add(name.trim());
        }
        return result;
    }

    public int getRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void printRaceStatus(List<ConditionCar> cars) {
        for (ConditionCar car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}