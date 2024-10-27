package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;
    private Long distance;

    private Car(String name) {
        this.name = name;
        this.distance = 0L;
    }

    public static List<Car> createInstances(String names) {
        List<Car> cars = new ArrayList<>();
        String[] tokens = names.split(",");
        for (String token: tokens) {
            cars.add(new Car(token.strip()));
        }
        return cars;
    }

    public Long getDistance() {
        return distance;
    }

    public void execute(final int command) {
        if (command >= 4) {
            this.distance++;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.name + " : ");
        for (int i=0; i<this.distance; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    @Override
    public int compareTo(Car car) {
        if (Objects.equals(this.distance, car.distance)) {
            return this.name.compareTo(car.name);
        }
        if (car.distance > this.distance) {
            return 1;
        }
        return -1;
    }
}
