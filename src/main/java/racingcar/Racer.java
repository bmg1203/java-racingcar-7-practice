package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Racer {
    private String name;
    private int position = 0;

    public Racer(String name){
        if(name.length()>5){
            throw new IllegalArgumentException(name + "의 길이가 5를 초과했습니다.");
        }
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void move(){
        if(Randoms.pickNumberInRange(0,9) >= 4)
            position++;
    }
}
