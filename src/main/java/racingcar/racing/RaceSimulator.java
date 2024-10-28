package racingcar.racing;

import static racingcar.config.RandomNumberConfig.MOVE_STAND_NUMBER;
import static racingcar.io.OutputUtil.println;

import java.util.List;
import racingcar.car.Car;
import racingcar.message.prompt.ResultPrompt;
import racingcar.util.RandomNumberGenerator;

public class RaceSimulator {
    public void startRace(List<Car> cars, long tryCount) {
        println(ResultPrompt.RESULT_PROMPT);

        while (tryCount-- > 0) {
            tryMoveCars(cars);
            println(getRacingProgress(cars));
        }
    }

    private void tryMoveCars(List<Car> cars) {
        cars.stream()
                .filter(car -> RandomNumberGenerator.getRandomNumber() >= MOVE_STAND_NUMBER)
                .forEach(Car::moveCar);
    }

    private String getRacingProgress(List<Car> cars) {
        StringBuilder racingProgress = new StringBuilder();

        for (Car car : cars) {
            racingProgress
                    .append(car.getCarName())
                    .append(" : ")
                    .append("-".repeat(car.getMoveDistance()))
                    .append('\n');
        }

        return racingProgress.toString();
    }
}
