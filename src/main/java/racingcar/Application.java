package racingcar;

import camp.nextstep.edu.missionutils.Console;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final int FORWARD_CRITERIA = 4;
    private static int[] carPositions;

    private static String[] getCarNames() {
        String carNames;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = Console.readLine();
        return splitCarNameByDelimiter(carNames);
    }

    private static String[] splitCarNameByDelimiter(String carNames) {
        return carNames.split(",");
    }

    private static int getGameCount() {
        String count;

        System.out.println("시도할 횟수는 몇 회인가요?");
        count = Console.readLine();
        return Integer.parseInt(count);
    }

    private static void goOrStop(String[] carNames) {
        int randomNumber;

        for (int i = 0; i < carNames.length; i++) {
            randomNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);

            if (randomNumber >= FORWARD_CRITERIA) {
                carPositions[i] += 1;
            }
        }
    }

    private static void printRaceStatus(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            System.out.print(carNames[i] + " : ");
            System.out.println("-".repeat(carPositions[i]));
        }
        System.out.println();
    }

    private static void startRaceNTimes(String[] carNames, int gameCount) {
        carPositions = new int[carNames.length];

        System.out.println("\n실행 결과");
        for (int i = 0; i < gameCount; i++) {
            goOrStop(carNames);
            printRaceStatus(carNames);
        }
    }

    public static void main(String[] args) {
        String[] carNames;
        int gameCount;

        carNames = getCarNames();
        gameCount = getGameCount();
        startRaceNTimes(carNames, gameCount);

        // 최종 우승자 출력
    }
}
