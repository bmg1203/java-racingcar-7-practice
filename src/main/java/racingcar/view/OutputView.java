package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.model.Car;

public class OutputView {
    static final String ROUND_RESULT_HEADER = "실행 결과\n";


    public static void printRoundResultHeader() {
        System.out.println(ROUND_RESULT_HEADER);
    }

    public static void printRoundResult(List<Car> racingCars) {
        String result = racingCars.stream().map(racingCar -> {
            String progressBar = Stream.generate(
                    () -> "-").limit(racingCar.getProgressCount()).collect(Collectors.joining());
            return racingCar.getName() + " : " + progressBar + "\n";
        }).collect(Collectors.joining());

        System.out.println(result);
    }

    public static void printWinnerResult(List<String> winnerNames) {
        String result = "최종 우승자 : " + winnerNames.stream().collect(Collectors.joining(", "));
        System.out.print(result);

    }
}
