package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        if(name == null || name.trim().isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name.trim();
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getProgress() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
