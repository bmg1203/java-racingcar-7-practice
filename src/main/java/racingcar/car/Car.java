package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.name.Name;

public class Car {

    private final int MOVEABLE_NUMBER = 4;
    private final String COLON_WITH_BLANK = " : ";
    private final String HYPHAN = "-";

    private final Name name;
    private int status;

    public Car (Name name){
        this.name = name;
    }

    public int getStatus(){
        return status;
    }

    public void move() {
        move(getRandomNum());
    }

    public void move(int num){
        if (num >= MOVEABLE_NUMBER) {
            status++;
        }
    }

    private int getRandomNum () {
        return  Randoms.pickNumberInRange(0, 9);
    }

    public String printStatus(){
        return name + COLON_WITH_BLANK + HYPHAN.repeat(status);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
