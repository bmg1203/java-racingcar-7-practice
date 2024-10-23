package racingcar.object.value;

import java.util.Objects;

public record CarName(String name) {

    public CarName {
        if (name == null) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }

        name = name.strip();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
        if (5 < name.length()) {
            throw new IllegalArgumentException("이름은 5자 이하로 입력해야 합니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof String otherName) {
            return name.equals(otherName);
        }
        return false;
    }

}
