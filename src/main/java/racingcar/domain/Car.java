package racingcar.domain;

public class Car {

    private static final int START_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = START_POSITION;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        validateNotBlank(name);
        validateMaxLength(name);
    }

    private static void validateNotBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 비어 있지 않아야 합니다.");
        }
    }

    private static void validateMaxLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }
}