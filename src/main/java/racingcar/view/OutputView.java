package racingcar.view;

public class OutputView {
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String LINE = "\n";

    public void printCarsResult(String carsPositionFormat) {
        System.out.println(carsPositionFormat + LINE);
    }

    public void printWinnerCars(String winnerCarsFormat) {
        System.out.printf(WINNER_MESSAGE, winnerCarsFormat);
    }

    public void printInitialCarPosition(String carsPositionFormat) {
        System.out.println(carsPositionFormat + LINE);
    }
}