package racingcar.domian.car;

public class Position {
    private int position;

    private Position() {
        this.position = 0;
    }

    public static Position createPosition() {
        return new Position();
    }

    public int getPosition() {
        return position;
    }

    public void forwardPosition() {
        position++;
    }

}
