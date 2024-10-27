package racingcar.View;

import java.util.ArrayList;
import racingcar.Enum.IOMessage;

public class OutputView {
  private static final String WINNERS_DELIMITER = ",";

  public static void printGameResult() {
    System.out.println(IOMessage.PRINT_GAME_RESULT.getMessage());
  }

  public static void printResultOfTurn(String gameResult) {
    System.out.println(gameResult);
  }

  public static void printWinner(ArrayList<String> winner) {
    String result = String.join(WINNERS_DELIMITER, winner);
    System.out.println(IOMessage.PRINT_GAME_WINNER.getMessage() + result);
  }
}
