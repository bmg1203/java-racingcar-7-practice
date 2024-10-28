package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.enums.Constants;

public class ResultView implements ResultViewInterface {

  @Override
  public void printRoundResult(List<Car> cars) {
    System.out.println();
    for (Car car : cars) {
      printCarResult(car);
    }
  }

  private static void printCarResult(Car car) {
    System.out.printf(Constants.INTERMEDIATE_RESULT_MESSAGE.getMessage(), car.getName());
    for (int i = 0; i < car.getPosition(); i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  @Override
  public void printWinners(List<Car> winners) {
    System.out.println();
    if (winners.size() == 1) {
      System.out.println(Constants.FINAL_RESULT_MESSAGE.getMessage() + winners.get(0).getName());
    } else {
      String winnerNames = String.join(", ",
          winners.stream().map(Car::getName).toArray(String[]::new));
      System.out.println(Constants.FINAL_RESULT_MESSAGE.getMessage() + winnerNames);
    }
  }
}

