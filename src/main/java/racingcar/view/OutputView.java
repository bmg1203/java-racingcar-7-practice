package racingcar.view;

import java.util.List;
import racingcar.enums.IOMessages;

public class OutputView {
    private static final char PRE_ELEMS = '[';
    private static final int FOR_NEXT_IDX = 1;
    private static final char POST_ELEMS = ']';

    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void roundResultHeader() {
        System.out.println(IOMessages.ROUND_RESULT_HEADER.getMsg());
    }

    public void printRoundResult(String allRoundStatus) {
        System.out.println(allRoundStatus);
    }

    public void printFinalResult(List<String> result) {
        System.out.print(IOMessages.PRE_RESULT.getMsg());
        String finalWinners = result.toString();
        System.out.println(removeBracket(finalWinners));
    }

    private String removeBracket(String finalWinners) {
        return finalWinners.substring(finalWinners.indexOf(PRE_ELEMS) + FOR_NEXT_IDX, finalWinners.indexOf(POST_ELEMS));
    }
}
