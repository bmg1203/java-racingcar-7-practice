package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static void requestCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void requestRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printRoundResult(List<Car> raceParticipants) {
        for (Car car : raceParticipants) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
        System.out.println();
    }


}
