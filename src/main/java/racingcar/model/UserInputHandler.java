package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.Parser;

public class UserInputHandler {
    String carNames ;
    public UserInputHandler(){
    }
    public String getName(){
        this.carNames = Console.readLine();
        return carNames;
    }
    public String [] splitCarNames(){
        return carNames.split(",");
    }
    public int getPlayTime(){
        Parser parser = new Parser();
        String play_times = Console.readLine();
        return(parser.stringToInt(play_times));
    }

}