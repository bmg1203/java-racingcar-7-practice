package racingcar;

public class RacingCar {

    private final String name;
    private int forwardCount;

    public RacingCar(String name) {
        this.name = name;
    }

    void move(int pickedNumber) {
        if (canMoveForward(pickedNumber)) {
            forwardCount++;
        }
    }

    static boolean canMoveForward(int pickedNumber) {
        return pickedNumber >= 4;
    }

    void displayRoundResult() {
        System.out.print(name + " : ");
        System.out.println("-".repeat(forwardCount));
    }

    boolean isWinner(int maxForwardCount) {
        return maxForwardCount == forwardCount;
    }

    String getName() {
        return name;
    }

    int getForwardCount() {
        return forwardCount;
    }
}
