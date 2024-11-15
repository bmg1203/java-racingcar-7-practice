package racingcar.domain;

public class Car {

    private static final int MAX_LENGTH = 4;
    private static final int MAX_RANDOM_NUM = 9;
    private static final int STANDARD_RANDOM_NUM = 4;
    private final String name;
    private int distance;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void plusDistance(int randomNum) {
        if(randomNum >= STANDARD_RANDOM_NUM && randomNum <= MAX_RANDOM_NUM) {
            distance++;
        }
    }
}
