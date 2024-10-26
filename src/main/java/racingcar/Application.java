package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public static void seperateCarNames(String carNames) {
        String[] carName = carNames.strip().split("\\s*,\\s*");
        isCarNameFiveCharsOrLess(carName);
        isCarNameDuplicate(carName);
        for (int i = 0; i < carName.length; i++) {
            car.put(carName[i], 0);
        }
    }

    public static void isCarNameFiveCharsOrLess(String[] carName) {
        for (int i = 0; i < carName.length; i++) {
            if (carName[i].length() >= 6) {
                throw new IllegalArgumentException("이름을 5자 이하로 입력해 주세요.");
            }
        }
    }

    public static void isCarNameDuplicate(String[] carName) {
        Set<String> chkCarName = new HashSet<>(Arrays.asList(carName));
        if (chkCarName.size() != carName.length) {
            throw new IllegalArgumentException("중복된 이름을 입력하였습니다.");
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

    public static void printInputMessageGameCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static int inputGameCount() {
        String gameCountStr = Console.readLine();
        isGameCountNumber(gameCountStr);
        int gameCount = Integer.parseInt(gameCountStr);
        isGameCountOneOrMore(gameCount);
        return gameCount;
    }

    public static void isGameCountNumber(String gameCountStr) {
        if (!gameCountStr.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public static void isGameCountOneOrMore(int gameCount) {
        if (gameCount <= 0) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력해 주세요.");
        }
    }

    public static void main(String[] args) {

    }
}
