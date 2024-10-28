package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    public void run(String[] names, int count) {
        List<Car> cars = initializeCars(names);
        System.out.println("\n실행 결과");

        for (int i = 0; i < count; i++) {
            forwardCondition(cars);
            presentStatus(cars);
            System.out.println();
        }

        printWinners(cars);
    }

    public List<Car> initializeCars(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public void forwardCondition(List<Car> cars) {
        for (Car car : cars) {
            if (isMovable()) {
                car.incrementMoveCount();
            }
        }
    }

    public boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public void presentStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + generateDashLine(car));
        }
    }

    public String generateDashLine(Car car) {
        StringBuilder dashLine = new StringBuilder();

        for (int i = 0; i < car.getMoveCount(); i++) {
            dashLine.append("-");
        }

        return dashLine.toString();
    }

    public void printWinners(List<Car> cars) {
        int maxMoveCount = findMaxMoveCount(cars);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getMoveCount() == maxMoveCount) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private int findMaxMoveCount(List<Car> cars) {
        int maxMoveCount = 0;

        for (Car car : cars) {
            if (car.getMoveCount() > maxMoveCount) {
                maxMoveCount = car.getMoveCount();
            }
        }

        return maxMoveCount;
    }
}
