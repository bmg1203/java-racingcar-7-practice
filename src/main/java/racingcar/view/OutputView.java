package racingcar.view;

import java.util.ArrayList;
import racingcar.constant.Constant;
import racingcar.model.RoundRecord;

public class OutputView {

    private ArrayList<RoundRecord> gameResult = new ArrayList<>();
    private int gameRound;

    public void setGameResult(ArrayList<RoundRecord> result) {
        gameResult = result;
    }

    public void setGameRound(int round) {
        gameRound = round;
    }

    public void printGameResult() {
        System.out.println(Constant.OUTPUT_PROMPT);

        for(int i=0; i<gameRound; i++) {
            gameResult.get(i).getRoundResult();
            System.out.println();
        }
    }
}
