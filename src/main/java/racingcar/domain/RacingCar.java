package racingcar.domain;

public class RacingCar {
    private String name;
    private int position;

    // private 생성자
    private RacingCar(Builder builder) {
        this.name = builder.name;
        this.position = builder.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    public static class Builder {
        private String name;
        private int position;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder position(int position) {
            this.position = position;
            return this;
        }

        public RacingCar build() {
            return new RacingCar(this);
        }
    }
}
