package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import object.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public class Error{
        public static final String EMPTY_INPUT_VALUE_MESSAGE = "값을 필수로 입력해야 합니다.";
        public static final String CAR_NAME_LENGTH_MESSAGE = "자동차의 이름은 5글자를 넘길 수 없습니다.";
        public static final String INVALID_NUMBER_MESSAGE = "유효한 숫자를 입력해야 합니다.";
    }

    public class GameConstants {
        public static final int MAX_CAR_NAME_LENGTH = 5;
        public static final int MIN_RANDOM_VALUE = 0;
        public static final int MAX_RANDOM_VALUE = 9;
        public static final int ADVANCE_THRESHOLD = 4;
    }

    public class TextFormat {
        public static final String CAR_STATUS_FORMAT = "%s : %s";
        public static final String DELIMITER = ",";
    }

    public static void main(String[] args) {
        String carName = carNameInput();
        List<String> carNameList = splitCarNamesByComma(carName);
        validateCarNames(carNameList);

        int tryCount = getTryCount();
        List<Car> cars = initializeCars(carNameList);

        startRace(cars, tryCount);
        printWinners(cars);
    }

    private static String carNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();

        isEmptyInputValue(carName);

        return carName;
    }

    private static List<String> splitCarNamesByComma(String carName) {
        return Arrays.asList(carName.split(TextFormat.DELIMITER));
    }

    private static void validateCarNames(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > GameConstants.MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(Error.CAR_NAME_LENGTH_MESSAGE);
            }
        }
    }

    private static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountInput = Console.readLine();

        isEmptyInputValue(tryCountInput);

        return parseTryCount(tryCountInput);
    }

    private static void isEmptyInputValue(String inputValue) {
        if (inputValue == null || inputValue.isEmpty()){
            throw new IllegalArgumentException(Error.EMPTY_INPUT_VALUE_MESSAGE);
        }
    }

    private static int parseTryCount(String tryCountInput) {
        try {
            return Integer.parseInt(tryCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_MESSAGE);
        }
    }

    private static List<Car> initializeCars(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNameList) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void startRace(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            raceRound(cars);
            System.out.println();
        }
    }

    private static void raceRound(List<Car> cars) {
        for (Car car : cars) {
            if (shouldAdvance()) {
                car.advance();
            }
            System.out.println(String.format(TextFormat.CAR_STATUS_FORMAT, car.getCarName(), "-".repeat(car.getPosition())));
        }
    }

    private static boolean shouldAdvance() {
        int randomValue = Randoms.pickNumberInRange(GameConstants.MIN_RANDOM_VALUE, GameConstants.MAX_RANDOM_VALUE);
        return randomValue >= GameConstants.ADVANCE_THRESHOLD;
    }

    private static void printWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winners = getWinners(cars, maxPosition);
        System.out.println("최종 우승자 : " + String.join(TextFormat.DELIMITER + " ", winners));
    }

    private static int getMaxPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    private static List<String> getWinners(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}

class Car {
    private final String carName;
    private int position = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void advance() {
        position++;
    }
}
