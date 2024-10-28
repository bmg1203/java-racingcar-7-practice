package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    /**
     * 랜덤 값이 4 이상이면 전진한다.
     */
    public void move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
