package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars() {
        this.carList = new ArrayList<>();
    }

    public Cars(Cars cars) {
        this.carList = new ArrayList<>();
        for (Car car : cars.getCarList()) {
            this.carList.add(new Car(car.getName(), car.getOrder(), car.getDistance()));
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public Cars sortWinnerCars() {
        int maxDistance = WinnerCalculator.findMaxDistance(this.getCarList());

        Cars winnerCars = new Cars();
        carList.forEach(car -> {
            if (car.getDistance().getDistanceValue() == maxDistance) {
                winnerCars.getCarList().add(car);
            }
        });
        return winnerCars;
    }

    public String toStringWinnerCars(Cars winnerCars) {
        return winnerCars.getCarList().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public void addCar(Car target) {
        carList.add(target);
    }

    public void addCarFromString(String input) {
        String[] names = input.split(",");

        for (int i = 0; i < names.length; i++) {
            Car car = new Car(names[i].trim(), i);
            addCar(car);
        }
    }

    public String toStringRoundResult() {
        StringBuilder result = new StringBuilder();
        for (Car car : this.carList) {
            result.append(car.getName()).append(" : ")
                    .append(car.getDistanceStatusBar(car.getDistance().getDistanceValue()))
                    .append("\n");
        }
        return result.toString();
    }

}
