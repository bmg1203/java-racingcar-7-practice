package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int FORWARD_STOP_THRESHOLD = 4;

    public static void main(String[] args) {
        // 1.1 경주할 자동차 목록을 입력받는 기능
        String carNamesInputString = getCarNamesInputString();
        // 1.2 경주할 자동차 목록을 쉼표(,)를 기준으로 구분하는 기능
        String[] carNames = getCarNames(carNamesInputString);
        // 1.3 경주할 자동차 목록이 형식에 맞지 않으면 예외를 발생시키는 기능
        validateCarNames(carNames);
        // 1.4 자동차(Car) 객체의 리스트를 생성하는 기능
        ArrayList<Car> carList = createCarList(carNames);

        // 2.1 시도할 횟수를 입력받는 기능
        String tryCountInputString = getTryCountInputString();
        // 2.2 시도할 횟수가 형식에 맞게 입력되었는지 확인하여 정수 타입으로 변환하는 기능
        int tryCount = getTryCount(tryCountInputString);

        // 3.1 0에서 9 사이의 무작위 수를 생성하여 자동차를 전진하거나 정지하게 하는 기능
        proceedTurn(carList);
    }

    public static String getCarNamesInputString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String[] getCarNames(String carNamesInputString) {
        return carNamesInputString.split(",");
    }

    public static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static ArrayList<Car> createCarList(String[] carNames) {
        ArrayList<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public static String getTryCountInputString() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public static int getTryCount(String tryCountInputString) {
        validateTryCount(tryCountInputString);
        return Integer.parseInt(tryCountInputString);
    }

    public static void validateTryCount(String tryCountInputString) {
        if (!isNumericString(tryCountInputString)) {
            throw new IllegalArgumentException();
        }
        if (!isPositiveNumber(Integer.parseInt(tryCountInputString))) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isNumericString(String tryCountInputString) {
        try {
            Integer.parseInt(tryCountInputString);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isPositiveNumber(int number) {
        return number > 0;
    }

    public static void proceedTurn(ArrayList<Car> carList) {
        for (Car car : carList) {
            int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
            if (randomValue >= FORWARD_STOP_THRESHOLD) {
                car.goForward();
            }
        }
    }
}
