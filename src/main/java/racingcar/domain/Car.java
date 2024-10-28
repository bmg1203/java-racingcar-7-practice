package racingcar.domain;

public class Car {
    private static final int MINIMUM_ADVANCE_VALUE = 4;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.distance = 0;
    }

    public Car(Car car) {
        this.name = car.name;
        this.distance = car.distance;
    }

    private void validateName(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자까지만 입력 가능합니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈칸일 수 없습니다.");
        }
    }

    public void setDistance(int randomNumber) {
        if (randomNumber >= MINIMUM_ADVANCE_VALUE) {
            this.distance += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
