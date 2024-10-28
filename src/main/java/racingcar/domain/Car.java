package racingcar.domain;

public class Car {

    private static final int NAME_LIMIT = 5;

    private final String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public void move() {
        ++position;
    }

    public static Car from(String name) {
        validateName(name);
        return new Car(name);
    }

    private static void validateName(String name) {
        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
