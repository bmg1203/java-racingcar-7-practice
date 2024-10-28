package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void randomMove() {
        int rand = Randoms.pickNumberInRange(0, 9);

        if (rand >= 4)
            position++;
    }
}
