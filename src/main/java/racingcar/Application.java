package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> carNames = getCarNames();
        List<Car> cars = createCars(carNames);

        Integer movementCount = getMovementCount();

        for (int i = 0; i < movementCount; i++) {
            for (Car car : cars) {
                Integer randomNumber = getRandomNumber();
                Boolean isValidNumber = isValidNumber(randomNumber);

                if (isValidNumber) {
                    car.addDistance();
                }
            }
        }
    }

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        String[] inputArray = input.split(",");

        for (String car : inputArray) {
            if (car.length() > 5)
                throw new IllegalArgumentException();
        }

        List<String> cars = Arrays.asList(input.split(","));

        return cars;
    }

    public static Integer getMovementCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String input = Console.readLine();

        if (!input.chars().allMatch(Character::isDigit))
            throw new IllegalArgumentException();

        Integer movemmetCount = Integer.parseInt(input);

        if (movemmetCount <= 0)
            throw new IllegalArgumentException();

        return movemmetCount;
    }

    public static Integer getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static Boolean isValidNumber(Integer number) {
        return number >= 4;
    }

    public static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(carName);
        }
        return cars;
    }
}
