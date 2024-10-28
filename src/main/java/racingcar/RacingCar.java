package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class RacingCar {

    private final String name;
    private int distance;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
        this.distance = 0;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void moveOrNot() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            distance++;
        }
    }

    @Override
    public String toString() {
        final String DISTANCE_BAR = "-";
        return name + " : " + DISTANCE_BAR.repeat(distance);
    }

}
