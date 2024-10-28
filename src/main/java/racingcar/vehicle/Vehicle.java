package racingcar.vehicle;

public abstract class Vehicle implements Movable {

    protected int forwardCount;
    protected int tryCount;
    protected String vehicleName;

    public Vehicle(String vehicleName, int tryCount) {
        if (vehicleName.length() >= 6) {
            throw new IllegalArgumentException("자동차 이름이 6글자 이상입니다.");
        }

        if (tryCount < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수가 될 수 없습니다.");
        }

        this.vehicleName = vehicleName;
        this.tryCount = tryCount;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
