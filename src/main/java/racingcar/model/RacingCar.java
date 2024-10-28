package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar implements Drivable {

    private static final int INITIAL_DISTANCE = 0;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = INITIAL_DISTANCE;
    }

    public RacingCar(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public void move() {
        if (canMoveForward()) {
            distance++;
        }
    }

    private boolean canMoveForward() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= MOVE_THRESHOLD;
    }
}
