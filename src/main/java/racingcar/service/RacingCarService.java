package racingcar.service;

import java.util.List;
import racingcar.dto.RacingResult;
import racingcar.model.Car;

public class RacingCarService {

    private final NumberGenerator numberGenerator;

    private static final int MINIMUM_MOVE_NUMBER = 4;

    public RacingCarService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public RacingResult startRacingGame(List<Car> cars, int tryCount) {

        StringBuilder racingResultBuilder = new StringBuilder();

        while (tryCount-- > 0) {
            moveCars(cars, racingResultBuilder);
        }

        int winnerPos = getWinnerPos(cars);
        List<String> winnerNames = generateWinnerResult(cars, winnerPos);

        return RacingResult.of(racingResultBuilder.toString(), winnerNames);
    }

    private void moveCars(List<Car> cars, StringBuilder racingResultBuilder) {

        for (Car car : cars) {
            if (numberGenerator.generateRandomNumber() >= MINIMUM_MOVE_NUMBER) {      // 전진
                car.go();
            }

            racingResultBuilder.append(car.getName()).append(" : ")
                    .append(car.getTrace()).append("\n");
        }
        racingResultBuilder.append("\n");
    }

    private int getWinnerPos(List<Car> cars) {

        return cars.stream()
                .mapToInt(Car::getPos)
                .max()
                .orElse(0);
    }

    private List<String> generateWinnerResult(List<Car> cars, int winnerPos) {

        return cars.stream()
                .filter(car -> car.getPos() == winnerPos)
                .map(Car::getName)
                .toList();
    }

}
