package model;

import service.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    private final List<Car> cars;
    private final int attempts;
    private RandomMoveStrategy randomMoveStrategy;
    public Race(List<String> carNames, int attempts) {
        if(attempts < 0) {
            throw new IllegalArgumentException("attempts can't be less than 0");
        }
        this.cars = new ArrayList<>(carNames.size());
        this.attempts = attempts;
        for(String name : carNames) {
            this.cars.add(new Car(name));
        }
    }
}
