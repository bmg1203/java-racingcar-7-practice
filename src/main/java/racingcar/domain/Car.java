package racingcar.domain;

import static racingcar.util.InputValidator.validateNotBlank;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private final Integer distance;

    public Car(String name, Integer distance) {
        validateNotBlank(name);
        this.name = name;
        this.distance = distance;
        validateCarNameLength();
    }

    public void moveForward() {
        if (getNumberInRange() >= 4) {
            this.distance++;
        }
    }

    private int getNumberInRange() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void validateCarNameLength() {
        if (this.name.length() > 5)
            throw new IllegalArgumentException();
    }
}
