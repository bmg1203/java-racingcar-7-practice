package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.util.NameParser;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.ArrayList;

public class RaceController {
    public void playRace() {
        String names = Input.inputCarName();
        ArrayList<String> nameList = NameParser.parse(names);

        int turn = Input.inputRaceTurn();
        Race race = new Race(turn);

        nameList.stream()
                .map(Car::new)
                .forEach(race::join);

        for (int i=0; i<turn; i++) {
            Output.printEachTurnResult(race.playOneTurn());
        }
    }
}
