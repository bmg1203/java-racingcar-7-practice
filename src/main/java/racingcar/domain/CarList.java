package racingcar.domain;

import static racingcar.utils.Constant.COMMA;
import static racingcar.utils.Constant.ENTER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class CarList {

    private final List<Car> cars;
    private Integer maxMoveCnt;

    public CarList() {
        this.cars = new ArrayList<>();
        this.maxMoveCnt = 0;
    }

    protected CarList(List<Car> cars) {
        this.cars = cars;
        this.maxMoveCnt = 0;
    }

    public static CarList from(CarNameCollect carNameCollect) {
        CarList carList = new CarList();
        Arrays.stream(carNameCollect.split())
                .map(CarName::create)
                .forEach(carList::add);

        return carList;
    }

    public void add(CarName carName) {
        Car car = Car.create(carName);
        cars.add(car);
    }

    public void moveAll() {
        cars.stream()
                .map(Car::move)
                .forEach(this::changeMaxMoveCnt);
    }

    protected String statusAll() {
        StringJoiner joiner = new StringJoiner(ENTER);

        for (Car car : this.cars) {
            joiner.add(car.status());
        }
        joiner.add(ENTER);

        return joiner.toString();
    }

    protected List<Car> toWinners() {
        return cars.stream()
                .filter(car -> car.isMaxMove(this.maxMoveCnt))
                .toList();
    }

    private void changeMaxMoveCnt(Integer moveCnt) {
        if (this.maxMoveCnt < moveCnt) {
            this.maxMoveCnt = moveCnt;
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(COMMA + " ");

        for (Car car : this.cars) {
            stringJoiner.add(car.toString());
        }

        return stringJoiner.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarList compareCarList = (CarList) o;
        return Objects.equals(cars, compareCarList.cars) && Objects.equals(maxMoveCnt,
                compareCarList.maxMoveCnt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, maxMoveCnt);
    }
}
