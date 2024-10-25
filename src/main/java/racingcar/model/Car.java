package racingcar.model;

public record Car(String name, int progress) {
    public Car(String name) {
        this(name, 0);
    }
}
