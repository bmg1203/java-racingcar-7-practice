package racingcar.view;

import java.util.List;
import racingcar.constants.OutputPrompts;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    private static final String DISTANCE_STRING = "-";

    public void tryResultPrint(Cars cars) {
        for (Car car : cars.getCars().values()) {
            System.out.printf(OutputPrompts.TRY_RESULT.getOutputPrompt(),
                    car.getName(), DISTANCE_STRING.repeat(car.getDistance()));
        }
    }

    public void winnersPrint(List<String> winners) {
        System.out.printf(OutputPrompts.FINAL_RESULT.getOutputPrompt(),
                String.join(", ", winners));
    }
}
