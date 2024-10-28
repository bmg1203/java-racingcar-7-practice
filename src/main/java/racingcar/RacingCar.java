package racingcar;

public class RacingCar {
    private final String name;
    private Integer score;

    private RacingCar(String name) {
        this.name = name;
        this.score = 0;
    }

    public void addScore() {
        this.score += 1;
    }

    public static RacingCar of(String name) {
        return new RacingCar(name);
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }
}
