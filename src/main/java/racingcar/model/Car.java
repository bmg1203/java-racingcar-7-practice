package racingcar.model;

public class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;

        validate();
    }

    private void validate() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 없어요.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 돼요.");
        }
        if (!name.matches("^[a-zA-Z0-9]*$")) {
            throw new IllegalArgumentException("자동차 이름은 영문 대소문자와 숫자만 돼요");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position += position;
    }
}
