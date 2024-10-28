package racingcar.model;

public class Car {

    private final String name;
    private int totalDistance;

    public Car(String name, int totalDistance) {
        this.name = name;
        this.totalDistance = totalDistance;
    }

    public Car(String name) {
        this(name, 0);
    }

    /**
     * 전진 시 총 주행 거리 증가
     */
    public void goForward() {
        totalDistance++;
    }

    public String getName() {
        return name;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

}
