package racingcar.io;

import racingcar.Car;

import java.util.List;

import static racingcar.constant.IOMessage.RESULT_HEAD;
import static racingcar.constant.IOMessage.WINNER_MESSAGE;

public class OutputHandler {

    public void printStart() {
        output(RESULT_HEAD);
    }

    public void printResult(List<String> winners) {
        String winnerMessage = String.join(", ", winners);
        output(WINNER_MESSAGE + winnerMessage);
    }

    public void printStatus(List<Car> cars) {
        for (Car car : cars) {
            output(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        output("");
    }

    private void output(String message) {
        System.out.println(message);
    }
}
