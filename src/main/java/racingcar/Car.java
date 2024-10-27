package racingcar;

public class Car {
    private String name;
    private int length;
    private int MIN_AVAILABLE_LENGTH = 4;
    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public void move(int random_val) {
        if (random_val >= MIN_AVAILABLE_LENGTH) length++;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }
}
