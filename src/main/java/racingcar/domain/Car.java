package racingcar.domain;

public class Car {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private String name;
    private int position;


    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        this.position++;
    }

    private void validateCarName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 5자 이하여야 합니다.");
        }
    }
}
