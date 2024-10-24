package racingcar.car;

public class RacingCar {

    private String carName;
    private int distance;

    public RacingCar(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public void forwardCar(int move) {
        distance += move;
    }

    public void printMoveStatus() {
        String currentCarStatus = carName + " : " + "=".repeat(distance);
        System.out.println(currentCarStatus);
    }
}
