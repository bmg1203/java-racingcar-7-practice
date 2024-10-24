package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Application {
    static Map<String, Integer> car = new HashMap<>();

    public static void printInputMessageCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static String inputCarName() {
        String carNames =  Console.readLine();
        isSeperatorPresent(carNames);
        isLastCharacterComma(carNames);
        return carNames;
    }

    public static void isSeperatorPresent(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("쉼표를 이용하여 자동차 이름을 2개 이상 입력해 주세요.");
        }
    }

    public static void isLastCharacterComma(String carNames) {
        if (carNames.charAt(carNames.length() - 1) == ',') {
            throw new IllegalArgumentException("쉼표 뒤에 자동차 이름을 입력해 주세요.");
        }
    }

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void moveOrStop(String carName, int randomNumber) {
        if (randomNumber >= 4) {
            car.put(carName, car.get(carName) + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(inputCarName());
    }
}
