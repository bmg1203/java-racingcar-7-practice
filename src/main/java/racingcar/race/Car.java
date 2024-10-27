package racingcar.race;

import java.util.Objects;

public class Car implements Vehicle {

    private String name;

    private Car() {}

    public Car(String name) {
        this.checkNameIsNullOrBlank(name);
        this.checkNameLength(name);

        this.name = name;
    }

    private void checkNameIsNullOrBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 필수입니다.");
        }
    }

    private void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5 글자를 초과할 수 없습니다.");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean move() {
        int randomValue = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 10);
        return randomValue >= 4;
    }

    @Override
    public String toString() {
        return "Car(name=" + this.getName() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Car)) return false;
        return this.name.equals(((Car) obj).getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }
}
