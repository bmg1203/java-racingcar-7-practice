package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private String name;
    private int position = 0;
    private final RandomNumberGenerator randomNumberGenerator;

    public Car(String name, RandomNumberGenerator randomNumberGenerator) {
        if (name.length() > 5 || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
        this.name = name.trim();
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void move() {
        int randomNumber = randomNumberGenerator.generate();
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
