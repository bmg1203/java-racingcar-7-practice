package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int advance;

    public Car(String name) {
        this.name = name;
        advance = 0;
    }

    public void doAdvance() {
        int random = Randoms.pickNumberInRange(0, 9);
        if(random >= 4) {
            advance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getAdvance() {
        return advance;
    }
}
