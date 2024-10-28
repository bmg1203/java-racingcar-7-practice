package racingcar.carAction;

public class CarActionProvider {

    private static final CarAction CAR_ACTION_FORWARD = new CarForward();
    private static final CarAction CAR_ACTION_STOP = new CarStop();


    private CarActionProvider() {
    }

    public static CarAction getForwardAction() {
        return CAR_ACTION_FORWARD;
    }

    public static CarAction getStopAction() {
        return CAR_ACTION_STOP;
    }
}
