package racingcar;

public class Car {
    private String name;
    private int score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int increaseScore() {
        score++;
        return score;
    }
}
