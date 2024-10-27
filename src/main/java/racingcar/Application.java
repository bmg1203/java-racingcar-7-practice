package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            List<Car> cars = initializeCars();
            int moveCount = initializeMoveCount();

            RacingGame racingGame = new RacingGame(cars, moveCount);
            racingGame.play();
            racingGame.printWinners();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Car> initializeCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(name.trim()));
        }
        return cars;
    }
    private static int initializeMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    public void printPosition() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

class RacingGame {
    private final List<Car> cars;
    private final int moveCount;

    public RacingGame(List<Car> cars, int moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public void play() {
        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            playRound();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
            car.printPosition();
        }
        System.out.println();
    }

    public void printWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
