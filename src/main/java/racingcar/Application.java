package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MOVE_CONDITION = 4; // 전진 조건 상수 추가

    public static void main(String[] args) {
        String[] carNames = inputCarNames();
        int moveCount = inputMoveCount();

        List<Car> cars = createCars(carNames);
        race(cars, moveCount);
        announceWinners(cars);
    }

    private static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateCarNames(input);
        return input.split(",");
    }

    private static int inputMoveCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        int moveCount = Integer.parseInt(Console.readLine());
        validateMoveCount(moveCount);
        return moveCount;
    }

    private static void validateCarNames(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다.");
            }
        }
    }

    private static void validateMoveCount(int moveCount) {
        if (moveCount <= 0) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
    }

    private static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void race(List<Car> cars, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            raceOneRound(cars);
            printCarPositions(cars);
        }
    }

    private static void raceOneRound(List<Car> cars) {
        for (Car car : cars) {
            if (shouldMove()) {
                car.move();
            }
        }
    }

    private static boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_CONDITION;
    }

    private static void printCarPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
        System.out.println();
    }

    private static void announceWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> winners = findWinners(cars, maxPosition);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getDistance());
        }
        return maxPosition;
    }

    private static List<String> findWinners(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}

class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        this.distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public String getPosition() {
        return "-".repeat(distance);
    }
}
