package racingcar.race;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;
import racingcar.Acceleration;
import racingcar.car.Car;

public class Race {

    private List<Car> cars;

    private Race(List<Car> cars) {
        this.cars = cars;
    }

    public static Race from(final String input, final Acceleration acceleration) {
        List<Car> cars = Arrays.stream(input.split(","))
            .map(name -> new Car(name, acceleration))
            .collect(Collectors.toUnmodifiableList());

        return new Race(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void lap() {
        cars.forEach(Car::move);
    }

    public String getResult() {
        return cars.stream()
            .map(Car::toString)  // 각 Car 객체의 toString()을 호출하여 문자열로 변환
            .collect(Collectors.joining("\n"));  // 각 자동차 결과를 줄바꿈으로 연결
    }
}
