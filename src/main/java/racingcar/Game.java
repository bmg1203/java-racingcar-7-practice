package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startGame() {
        String[] names = inputView.getInput();
        int count = inputView.getCount();
        Race race = new Race(names, count);
        race.raceCars();

    }

}



